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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ar.com.avantrip.repository.BlacklistRepository;
import ar.com.avantrip.repository.RulesRepository;
import ar.com.avantrip.repository.ScoreRepository;
import ar.com.avantrip.service.RulesService;
import ar.com.avantrip.service.ScoreService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ConfigController.class, secure=false)
public class ConfigControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ScoreService scoreService;
	
	@MockBean
	private RulesService rulesService;
	
	@MockBean
	private ScoreRepository scoreRepository;
	
	@MockBean
	private RulesRepository rulesRepository;
	
	@MockBean
	private BlacklistRepository blacklistRepository;
	
	private String jsonScoreRequest = "{\r\n" + 
			"	\"id\": \"\",\r\n" + 
			"	\"score\":100,\r\n" + 
			"	\"scoreMaxFraud\": 150,\r\n" + 
			"	\"creationDate\": \"\"\r\n" + 
			"}";
	
	private String jsonArrayRulesRequest = "[\r\n" + 
			"    {\r\n" + 
			"        \"id\": \"1\",\r\n" + 
			"        \"nameRule\": \"total de  compraasdkammdasñmd\",\r\n" + 
			"        \"descriptionRule\": \"supera los 50.000,00 pesos A$R\",\r\n" + 
			"        \"priorityRule\": 1,\r\n" + 
			"        \"conditionRule\": \"(fraudulentFlightRequest.getFlightDetail().getDetailPaymentOption().getAmount() > 1555) || (fraudulentFlightRequest.getFlightDetail().getUser().getUserName().equals(new String('arturo_jcn')));\",\r\n" + 
			"        \"actionRule\": \"fraudulentFlightRequest.setScoring(fraudulentFlightRequest.getScoring() + 795);\",\r\n" + 
			"        \"active\": true\r\n" + 
			"    }\r\n" + 
			"]";

	private String urlScore = "http://127.0.0.1:8080/config/score";
	private String urlRules = "http://127.0.0.1:8080/config/rules";
	
	@Test
	public void testUpdateScore() throws Exception {

		mvc.perform(put(urlScore).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonScoreRequest)).andExpect(status().isOk());
		mvc.perform(put(urlScore).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("hellorAvantrip")).andExpect(status().isBadRequest());
		mvc.perform(put(urlScore).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isBadRequest());
		mvc.perform(post(urlScore).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isMethodNotAllowed());
		mvc.perform(delete(urlScore).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isMethodNotAllowed());
		mvc.perform(get(urlScore).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isMethodNotAllowed());
		
	}

	@Test
	public void testListRules() throws Exception {

		mvc.perform(get(urlRules).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk());
	}

	@Test
	public void testSaveRules() throws Exception {

		mvc.perform(post(urlRules).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonArrayRulesRequest)).andDo(print()).andExpect(status().isOk());
		mvc.perform(delete(urlRules).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonArrayRulesRequest)).andDo(print()).andExpect(status().isMethodNotAllowed());
		mvc.perform(get(urlRules).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonArrayRulesRequest)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testUpdateRules() throws Exception {
		
		mvc.perform(put(urlRules).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonArrayRulesRequest)).andDo(print()).andExpect(status().isOk());
		mvc.perform(put(urlRules).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content("HelloAvantrip")).andDo(print()).andExpect(status().isBadRequest());
	}
}
