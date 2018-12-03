package ar.com.avantrip.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.avantrip.binding.FraudulentFlightRequest;
import ar.com.avantrip.binding.PayementResquest;
import ar.com.avantrip.repository.FraudulentFlightRepository;

@Service
public class FraudulentFlightService implements FraudulentFlightRepository {


	private static Logger logger = Logger.getLogger(FraudulentFlightService.class.getCanonicalName());

	@Autowired
	private ScoreService scoreService;
	
	public boolean fraudFlight(FraudulentFlightRequest request) {
		logger.info("fraudFlight()");
		boolean fraud = false;
		int score = 0;
		
		score = scoreService.findScore();
		logger.info("score config is: " + score);
		int scoring = calculateScoring(request);
		logger.info("score config is: " + score + " > " + scoring + " :calculate scoring?");
		if(score > scoring)
			fraud = true;
		return fraud;
	}
	
	@Override
	public Integer calculateScoring(FraudulentFlightRequest request) {
		int scoring = 80;
		//here verify rules for will calculate the scoring for buy
		return scoring;
	}
	
	@Override
	public boolean blackList(PayementResquest paymentRequest) {
		boolean isBlackList = false;
		//here verify if cars is in blackList
		return isBlackList;
	}

}
