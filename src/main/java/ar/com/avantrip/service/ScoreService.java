package ar.com.avantrip.service;


import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.avantrip.binding.ScoreResquest;
import ar.com.avantrip.repository.ScoreRepository;

@Service
public class ScoreService {	

	private static Logger logger = Logger.getLogger(ScoreService.class.getCanonicalName());
	@Autowired
	private ScoreRepository scoreRepository;

	public int findScore(){
		logger.info("findScore()");
		ScoreResquest scoreResquest = new ScoreResquest();
		try {
			scoreResquest = scoreRepository.findOne((long) 1);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			throw new RuntimeException("No se encontro Score configurado");
		}
		return scoreResquest.getScore();
	}
	
	public ScoreResquest updateScore(ScoreResquest score) {
		logger.info("updateScore()");
		int scoring = score.getScore();
		if(scoring > 100 || scoring < 0) {
			logger.warning("Score debe estar entre los valores 0 y 100 inclusive");
			throw new RuntimeException("Score debe estar entre los valores 0 y 100 inclusive");
		}
		score.setId((long) 1);
		score.setCreationDate(new Date());
		return scoreRepository.save(score);
	}

}
