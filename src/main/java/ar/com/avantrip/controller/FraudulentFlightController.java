package ar.com.avantrip.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.avantrip.binding.FraudulentFlightRequest;
import ar.com.avantrip.service.FraudulentFlightService;

@RestController
@RequestMapping(value = "/service", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })
public class FraudulentFlightController {

	private static Logger logger = Logger.getLogger(FraudulentFlightController.class.getCanonicalName());
	
	@Autowired
	private FraudulentFlightService fraudulentFlighService;

	@PostMapping(value="fraudulent")
	public ResponseEntity<Boolean> fraudulentFlight(@RequestBody FraudulentFlightRequest request) {
		logger.info("fraudulentFlight()");
		return new ResponseEntity<Boolean>(fraudulentFlighService.fraudFlight(request), HttpStatus.OK);
	}
	

	@PostMapping(value="scoring")
	public ResponseEntity<Integer> scoringFlight(@RequestBody FraudulentFlightRequest request) {
		logger.info("scoringFlight()");		
		return new ResponseEntity<Integer>(fraudulentFlighService.calculateScoring(request), HttpStatus.OK);
	}
	
}
