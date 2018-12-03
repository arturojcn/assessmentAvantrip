package ar.com.avantrip.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ar.com.avantrip.binding.ScoreResquest;
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
	public CommandLineRunner dbRun(ScoreRepository scoreRepository) {
		return (arg) -> {
			scoreRepository.save(new ScoreResquest(60));
		};
	}
	
}
