package ar.com.avantrip.controller;


import java.sql.SQLException;
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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/service", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })
public class FraudulentFlightController {

	private static Logger logger = Logger.getLogger(FraudulentFlightController.class.getCanonicalName());
	
	@Autowired
	private FraudulentFlightService fraudulentFlighService;

	@ApiOperation(value="Return true if a flight is fraudulent otherwise false", notes="This Method determinate first the scoring of the flight buy and compare with Score that was configured and if result higher or equal, the flight buy is fraudulent")
	@PostMapping(value="fraudulent")
	public ResponseEntity<Boolean> fraudulentFlight(@RequestBody FraudulentFlightRequest request) throws SQLException {
		logger.info("fraudulentFlight()");
		return new ResponseEntity<Boolean>(fraudulentFlighService.fraudFlight(request), HttpStatus.OK);
	}

	@ApiOperation(value="Return an int scoring of fraudulent for flight buy", notes="This method verify the rules application to the buy and calculate the scoring, if score is higher or equal that maxScoreFraud return the maxScoreFraud ")
	@PostMapping(value="scoring")
	public ResponseEntity<Integer> scoringFlight(@RequestBody FraudulentFlightRequest request) throws SQLException {
		logger.info("scoringFlight()");		
		return new ResponseEntity<Integer>(fraudulentFlighService.calculateScoring(request), HttpStatus.OK);
	}
	
}
