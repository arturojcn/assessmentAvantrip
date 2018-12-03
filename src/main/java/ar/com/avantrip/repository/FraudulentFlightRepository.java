package ar.com.avantrip.repository;

import org.springframework.stereotype.Service;

import ar.com.avantrip.binding.FraudulentFlightRequest;
import ar.com.avantrip.binding.PayementResquest;

@Service
public interface FraudulentFlightRepository {

	boolean fraudFlight(FraudulentFlightRequest request);
	 
	Integer calculateScoring(FraudulentFlightRequest request);
	
	boolean blackList(PayementResquest paymentRequest);
}
