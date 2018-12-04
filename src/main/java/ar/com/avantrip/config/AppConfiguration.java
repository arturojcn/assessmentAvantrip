package ar.com.avantrip.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ar.com.avantrip.binding.RulesResquest;
import ar.com.avantrip.binding.ScoreResquest;
import ar.com.avantrip.repository.RulesRepository;
import ar.com.avantrip.repository.ScoreRepository;


@SuppressWarnings("deprecation")
@Configuration
@Import({ SwaggerConfiguration.class })
public class AppConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
	public CommandLineRunner dbRun(ScoreRepository scoreRepository, RulesRepository rulesRepository) {
		return (arg) -> {
			scoreRepository.save(new ScoreResquest(60));
			rulesRepository.save(new RulesResquest(
					"total de la compra",
					"Verifica si el total de la compra supera los 50.000,00 pesos A$R",
					1,
					"(fraudulentFlightRequest.getFlightDetail().getDetailPaymentOption().getAmount() > 50000);",
					"fraudulentFlightRequest.setScoring(15);",
					true)
				);
			rulesRepository.save(new RulesResquest(
					"Pais limitorfe", 
					"Verifica si el destino del vuelo es un pais limitrofe", 
					1, 
					 "(fraudulentFlightRequest.getFlightDetail().getDetailTrip().getDestiny().trim().equals('CHILE'));",
					"fraudulentFlightRequest.setScoring(40)",
					true)
				);
		};
	}
	
}
