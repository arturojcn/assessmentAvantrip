package ar.com.avantrip.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ar.com.avantrip.binding.ScoreResquest;
import ar.com.avantrip.service.ScoreService;

@RestController
@RequestMapping(value = "/config", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })
public class ConfigController {

	private static Logger logger = Logger.getLogger(ConfigController.class.getCanonicalName());
	@Autowired
	private ScoreService scoreService;

	@PutMapping(value="score")
	public ResponseEntity<ScoreResquest> updateScore(@RequestBody ScoreResquest score){
		logger.info("updateScore()");
		return new ResponseEntity<ScoreResquest>(scoreService.updateScore(score), HttpStatus.OK);
	}
}
