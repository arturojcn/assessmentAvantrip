package ar.com.avantrip.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.avantrip.binding.RulesResquest;
import ar.com.avantrip.repository.RulesRepository;

@Service
public class RulesService {

	private static Logger logger = Logger.getLogger(RulesService.class.getCanonicalName());
	
	@Autowired
	private RulesRepository rulesRepository;
	
	public Iterable<RulesResquest> listAllRules(){
		logger.info("listAllRules()");
		return rulesRepository.findAll();
	}
	
	public Iterable<RulesResquest> saveRule(Iterable<RulesResquest> ruleRequest) {
		logger.info("saveRule()");
		return rulesRepository.save(ruleRequest);
	}
}
