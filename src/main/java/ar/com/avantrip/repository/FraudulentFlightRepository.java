package ar.com.avantrip.repository;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import ar.com.avantrip.binding.FraudulentFlightRequest;

@Service
public interface FraudulentFlightRepository {

	boolean fraudFlight(FraudulentFlightRequest request);
	 
	Integer calculateScoring(FraudulentFlightRequest request);
	
	boolean isBlackList(String cardNumber) throws SQLException;
}
