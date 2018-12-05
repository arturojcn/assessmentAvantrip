package ar.com.avantrip.service;

import java.sql.SQLException;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.avantrip.binding.BlacklistCardRequest;
import ar.com.avantrip.repository.BlacklistRepository;

@Service
public class BlacklistService {

	private static Logger logger = Logger.getLogger(BlacklistService.class.getCanonicalName());
    @PersistenceContext
    private EntityManager em;
    
	@Autowired
	private BlacklistRepository blacklistRepository;
	
	public Iterable<BlacklistCardRequest> getAllBlackList(){
		return blacklistRepository.findAll();
	}
	public boolean findCardBlackList(String cardNumber) throws SQLException{
		boolean res = false;
		BlacklistCardRequest result = null;
		String sqlString = "SELECT * FROM blacklist_card_request WHERE card_number_front = ? ;";
		
		Query nativeQuery = em.createNativeQuery(sqlString, BlacklistCardRequest.class);
		nativeQuery.setParameter(1, cardNumber);
		try {
			
			result = (BlacklistCardRequest) nativeQuery.getSingleResult();

		} catch (Exception e) {
			logger.severe("EROROR: " + e.getMessage());
		}
		if(result != null) {
				logger.info("	Card was found in Blacklist");
				res= true;
		}else
			logger.info("	Card was found in Blacklist");
		
		return res;
	}

}
