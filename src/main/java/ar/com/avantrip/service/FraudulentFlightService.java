package ar.com.avantrip.service;

import java.sql.SQLException;
import java.util.logging.Logger;


import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.avantrip.binding.CalculateScoringRequest;
import ar.com.avantrip.binding.FraudulentFlightRequest;
import ar.com.avantrip.binding.RulesResquest;
import ar.com.avantrip.binding.ScoreResquest;
import ar.com.avantrip.repository.FraudulentFlightRepository;

@Service
public class FraudulentFlightService implements FraudulentFlightRepository {


	private static Logger logger = Logger.getLogger(FraudulentFlightService.class.getCanonicalName());

	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private RulesService rulesService;
	
	@Autowired
	BlacklistService blacklistService;

	@Override
	public boolean fraudFlight(FraudulentFlightRequest request) {
		logger.info("fraudFlight()");
		boolean fraud = false;
		int score = 0;
		ScoreResquest scoreResquest = scoreService.findScore(); 
		score = scoreResquest.getScore();
		
		logger.info("score config is: " + score);
		int scoring = calculateScoring(request);
		logger.info("score config is: " + score + " > " + scoring + " :calculate scoring?");
		if(scoring >= score)
			fraud = true;
		return fraud;
	}
	
	@Override
	public Integer calculateScoring(FraudulentFlightRequest request) {
		int scoring = 0;
		int maxScoreFraud = 0;
		ScoreResquest scoreResquest = scoreService.findScore(); 
		maxScoreFraud = scoreResquest.getScoreMaxFraud();
		
		try {
			if(isBlackList(request.getDetailPaymentOption().getCardNumberFront())) {
				logger.info("tarjeta encontrada en la blacklist retorno el maximo score de fraude");
				return (maxScoreFraud);
			}
			
			CalculateScoringRequest calculateSCoring = new CalculateScoringRequest(0, request);
				
			Facts fact = new Facts();
			fact.put("fraudulentFlightRequest", calculateSCoring);
			
			Iterable<RulesResquest> rules = rulesService.listAllActivesRules();
			for (RulesResquest rulesResquest : rules) {
				
				calculateSCoring.setScoring(0);
				MVELRule evaluateRule = new MVELRule().name(rulesResquest.getNameRule())
						.description(rulesResquest.getDescriptionRule()).priority(rulesResquest.getPriorityRule())
						.when(rulesResquest.getConditionRule()).then(rulesResquest.getActionRule());

				Rules rulesRule = new Rules();
				rulesRule.register(evaluateRule);

				RulesEngine rulesEngine = new DefaultRulesEngine();
				logger.info("Ejecutando regla");
				rulesEngine.fire(rulesRule, fact);
				scoring += calculateSCoring.getScoring();
				
				///Si el escoring calculado es hasta acá es mayor o igual al maxscore fraude devuuelvo el maxScoreFraud 
				if(scoring >= maxScoreFraud )
					return (maxScoreFraud);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return scoring;
	}

	@Override
	public boolean isBlackList(String cardNumber) throws SQLException {
		logger.info("isBlackList()");
		return blacklistService.findCardBlackList(cardNumber);
	}


}
