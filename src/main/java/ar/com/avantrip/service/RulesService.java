package ar.com.avantrip.service;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.avantrip.binding.RulesResquest;
import ar.com.avantrip.repository.RulesRepository;

@Service
public class RulesService {

	private static Logger logger = Logger.getLogger(RulesService.class.getCanonicalName());
	
	@Autowired
	private RulesRepository rulesRepository;

    @PersistenceContext
    private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<RulesResquest> listAllActivesRules(){
		logger.info("listAllActivesRules()");
		List<RulesResquest> activeRules = null;
		String sqlQuery = "SELECT * FROM RULES_RESQUEST WHERE is_active = true;";
	    
		Query nativeQuery = em.createNativeQuery(sqlQuery, RulesResquest.class);
		try {
			activeRules = (List<RulesResquest>) nativeQuery.getResultList();

		} catch (Exception e) {
			logger.severe("EROROR: " + e.getMessage());
		}
		
		return activeRules;
	}
	
	public Iterable<RulesResquest> listAllRules(){
		logger.info("listAllRules()");
		return rulesRepository.findAll();
	}
	
	public Iterable<RulesResquest> saveRule(Iterable<RulesResquest> ruleRequest) {
		logger.info("saveRule()");
		return rulesRepository.save(ruleRequest);
	}
}
