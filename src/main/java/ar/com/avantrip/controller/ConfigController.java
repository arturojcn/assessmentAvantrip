package ar.com.avantrip.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.avantrip.binding.RulesResquest;
import ar.com.avantrip.binding.ScoreResquest;
import ar.com.avantrip.service.RulesService;
import ar.com.avantrip.service.ScoreService;

@RestController
@RequestMapping(value = "/config", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })
public class ConfigController {

	private static Logger logger = Logger.getLogger(ConfigController.class.getCanonicalName());
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private RulesService rulesService;
	
	@PutMapping(value="score")
	public ResponseEntity<ScoreResquest> updateScore(@RequestBody ScoreResquest score){
		logger.info("updateScore()");
		return new ResponseEntity<ScoreResquest>(scoreService.updateScore(score), HttpStatus.OK);
	}
	
	@GetMapping(value="rules")
	public ResponseEntity<Iterable<RulesResquest>> listRules(){
		logger.info("listRules");
		return new ResponseEntity<Iterable<RulesResquest>>(rulesService.listAllRules(), HttpStatus.OK);
	}

	@PostMapping(value="rules")
	public ResponseEntity<Iterable<RulesResquest>> saveRules(@RequestBody Iterable<RulesResquest> ruleRequest){
		return new ResponseEntity<Iterable<RulesResquest>>(rulesService.saveRule(ruleRequest), HttpStatus.OK);
	}
	
	@PutMapping(value="rules")
	public ResponseEntity<Iterable<RulesResquest>> UpdateRules(@RequestBody Iterable<RulesResquest> ruleRequest){
		return new ResponseEntity<Iterable<RulesResquest>>(rulesService.saveRule(ruleRequest), HttpStatus.OK);
	}
	
}
