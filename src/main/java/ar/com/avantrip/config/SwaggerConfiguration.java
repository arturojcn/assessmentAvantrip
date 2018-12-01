package ar.com.avantrip.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfiguration {
	
	 @Bean
	    public Docket apiDocket() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("ar.com.avantrip.controller"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(getApiInfo());
	    }
	 
	 private ApiInfo getApiInfo() {
		    return new ApiInfo(
		            "TITLE",
		            "DESCIPRION",
		            "VERSION",
		            "TERMS OF SERVICE URL",
		            new Contact("NAME","URL","EMAIL"),
		            "LICENSE",
		            "LICENSE URL",
		            Collections.emptyList()
		);
	}
}
