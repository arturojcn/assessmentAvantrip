package ar.com.avantrip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.avantrip.binding.FraudulentFlightRequest;
import ar.com.avantrip.service.FraudulentFlightService;

@RestController
@RequestMapping(value = "/v1/fraudulent", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }, produces = {
		MediaType.APPLICATION_JSON_UTF8_VALUE })
public class FraudulentFlightController {
	
	@Autowired
	private FraudulentFlightService fraudulentFlighService;
	
	@PostMapping
	public void buyFlight(@RequestBody FraudulentFlightRequest request) {
		
	}
}
