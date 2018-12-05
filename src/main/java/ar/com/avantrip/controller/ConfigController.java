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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/config", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })
public class ConfigController {

	private static Logger logger = Logger.getLogger(ConfigController.class.getCanonicalName());
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private RulesService rulesService;
	
	@ApiOperation(value="Return an Entity score that was modifed", notes="This method update the configuration of score and maxScoreFraud")
	@PutMapping(value="score")
	public ResponseEntity<ScoreResquest> updateScore(@RequestBody ScoreResquest score){
		logger.info("updateScore()");
		return new ResponseEntity<ScoreResquest>(scoreService.updateScore(score), HttpStatus.OK);
	}

	@ApiOperation(value="Return an list of rules for calculate scoring the flight buy", notes="This method list all rules that were almacenatedd")
	@GetMapping(value="rules")
	public ResponseEntity<Iterable<RulesResquest>> listRules(){
		logger.info("listRules");
		return new ResponseEntity<Iterable<RulesResquest>>(rulesService.listAllRules(), HttpStatus.OK);
	}

	@ApiOperation(value="Return an list of rules that was saved for calculate scoring the flight buy", notes="This method save one or a list of the rules that will aplicate for calculate of scoring of flight buy")
	@PostMapping(value="rules")
	public ResponseEntity<Iterable<RulesResquest>> saveRules(@RequestBody Iterable<RulesResquest> ruleRequest){
		return new ResponseEntity<Iterable<RulesResquest>>(rulesService.saveRule(ruleRequest), HttpStatus.OK);
	}

	@ApiOperation(value="Return an list of rules that was modified for calculate scoring the flight buy", notes="This method update one or a list of the rules that will aplicate for calculate of scoring of flight buy")
	@PutMapping(value="rules")
	public ResponseEntity<Iterable<RulesResquest>> UpdateRules(@RequestBody Iterable<RulesResquest> ruleRequest){
		return new ResponseEntity<Iterable<RulesResquest>>(rulesService.saveRule(ruleRequest), HttpStatus.OK);
	}
	
}
