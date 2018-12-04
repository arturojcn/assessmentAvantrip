package ar.com.avantrip.service;

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
import ar.com.avantrip.binding.PayementResquest;
import ar.com.avantrip.binding.RulesResquest;
import ar.com.avantrip.repository.FraudulentFlightRepository;

@Service
public class FraudulentFlightService implements FraudulentFlightRepository {


	private static Logger logger = Logger.getLogger(FraudulentFlightService.class.getCanonicalName());

	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private RulesService rulesService;

	public boolean fraudFlight(FraudulentFlightRequest request) {
		logger.info("fraudFlight()");
		boolean fraud = false;
		int score = 0;
		
		score = scoreService.findScore();
		logger.info("score config is: " + score);
		int scoring = calculateScoring(request);
		logger.info("score config is: " + score + " > " + scoring + " :calculate scoring?");
		if(scoring >= score)
			fraud = true;
		return fraud;
	}
	
	public Integer calculateScoring(FraudulentFlightRequest request) {
		int scoring = 0;
		CalculateScoringRequest calculateSCoring = new CalculateScoringRequest(0, request);
		//mejorar este metodo para que quede mas prolijo
		Facts fact = new Facts();
		fact.put("fraudulentFlightRequest", calculateSCoring);
		
		Iterable<RulesResquest> rules = rulesService.listAllRules();
		for (RulesResquest rulesResquest : rules) {
			if(rulesResquest.isActive()) {
				calculateSCoring.setScoring(0);
				MVELRule evaluateRule = new MVELRule()
		                .name(rulesResquest.getNameRule())
		                .description(rulesResquest.getDescriptionRule())
		                .priority(rulesResquest.getPriorityRule())
		                .when(rulesResquest.getConditionRule())
		                .then(rulesResquest.getActionRule());
				
				Rules rulesRule = new Rules();
				rulesRule.register(evaluateRule);
				
				RulesEngine rulesEngine = new DefaultRulesEngine();
				logger.info("Ejecutando regla");
				rulesEngine.fire(rulesRule, fact);
				scoring += calculateSCoring.getScoring();
			}
		}
		return scoring;
	}
	
	public boolean blackList(PayementResquest paymentRequest) {
		boolean isBlackList = false;
		//here verify if cars is in blackList
		return isBlackList;
	}

}
