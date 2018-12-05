package ar.com.avantrip.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import ar.com.avantrip.repository.BlacklistRepository;
import ar.com.avantrip.repository.RulesRepository;
import ar.com.avantrip.repository.ScoreRepository;
import ar.com.avantrip.service.FraudulentFlightService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FraudulentFlightController.class, secure=false)
public class FraudulentFlightControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private FraudulentFlightService fraudulentFlightService;
	
	@MockBean
	private ScoreRepository scoreRepository;
	
	@MockBean
	private RulesRepository rulesRepository;
	
	@MockBean
	private BlacklistRepository blacklistRepository;

	private String jsonFraudulentFlightRequest = "{\r\n" + 
			"	\"user\": {\r\n" + 
			"		\"userName\": \"arturo_jcn\",\r\n" + 
			"		\"email\": \"arturo@gmail.com\",\r\n" + 
			"		\"password\": \"qwerty\",\r\n" + 
			"		\"userDetail\": {\r\n" + 
			"			\"name\": \"Arturo\",\r\n" + 
			"			\"lastName\": \"Cabrera\",\r\n" + 
			"			\"dni\": 1234556,\r\n" + 
			"			\"phone\": \"1234-5678\",\r\n" + 
			"			\"address\": \"My home\"\r\n" + 
			"		}\r\n" + 
			"	},\r\n" + 
			"	\"passengers\":[\r\n" + 
			"		{\r\n" + 
			"			\"name\": \"Arturo\",\r\n" + 
			"			\"lastName\": \"Cabrera\",\r\n" + 
			"			\"dni\": 1234556,\r\n" + 
			"			\"phone\": \"1234-5678\",\r\n" + 
			"			\"address\": \"My home\"\r\n" + 
			"		}\r\n" + 
			"	],\r\n" + 
			"	\"detailPaymentOption\":{\r\n" + 
			"		\"datePurchase\" : \"2018-11-30T09:45:00.000+02:00\",\r\n" + 
			"		\"titularDetail\":{\r\n" + 
			"			\"name\": \"Arturo\",\r\n" + 
			"			\"lastName\": \"Cabrera\",\r\n" + 
			"			\"dni\": 1234556,\r\n" + 
			"			\"phone\": \"1234-5678\",\r\n" + 
			"			\"address\": \"My home\"\r\n" + 
			"		},\r\n" + 
			"		\"cardNumberFront\": \"9632514784563\",\r\n" + 
			"		\"cardNumberCVC\": \"911\",\r\n" + 
			"		\"amount\": 100000,\r\n" + 
			"		\"billing\" : {\r\n" + 
			"			\"name\": \"Arturo\",\r\n" + 
			"			\"lastName\": \"Cabrera\",\r\n" + 
			"			\"dni\": 1234556,\r\n" + 
			"			\"phone\": \"1234-5678\",\r\n" + 
			"			\"address\": \"My home\"\r\n" + 
			"		}\r\n" + 
			"	},\r\n" + 
			"	\"detailTrip\":{\r\n" + 
			"		\"isOneWay\": true,\r\n" + 
			"		\"origen\": \"Argentina\",\r\n" + 
			"		\"destiny\": \"CHILE\",\r\n" + 
			"		\"departureDate\": \"2018-12-10T09:45:00.000+02:00\",\r\n" + 
			"		\"returnDate\": \"2018-12-22T09:45:00.000+02:00\"\r\n" + 
			"	}\r\n" + 
			"}";

	private String urlFraudulent = "http://127.0.0.1:8080/service/fraudulent";
	private String urlScoring = "http://127.0.0.1:8080/service/scoring";
	
	@Test
	public void testFraudulentFlight() throws Exception {

		mvc.perform(post(urlFraudulent).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonFraudulentFlightRequest)).andDo(print()).andExpect(status().isOk());
		mvc.perform(get(urlFraudulent).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print()).andExpect(status().isMethodNotAllowed());
		mvc.perform(put(urlFraudulent).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonFraudulentFlightRequest)).andDo(print()).andExpect(status().isMethodNotAllowed());
		mvc.perform(delete(urlFraudulent).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonFraudulentFlightRequest)).andDo(print()).andExpect(status().isMethodNotAllowed());
		
	}

	@Test
	public void testScoringFlight() throws Exception {

		mvc.perform(post(urlScoring).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonFraudulentFlightRequest)).andDo(print()).andExpect(status().isOk());
		mvc.perform(post(urlScoring).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("helloAvantrip")).andDo(print()).andExpect(status().isBadRequest());
		mvc.perform(get(urlScoring).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print()).andExpect(status().isMethodNotAllowed());
		mvc.perform(put(urlScoring).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonFraudulentFlightRequest)).andDo(print()).andExpect(status().isMethodNotAllowed());
		mvc.perform(delete(urlScoring).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonFraudulentFlightRequest)).andDo(print()).andExpect(status().isMethodNotAllowed());
		
	}

}
