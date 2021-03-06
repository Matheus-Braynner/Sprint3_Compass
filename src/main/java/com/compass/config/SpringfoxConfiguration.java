package com.compass.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SpringfoxConfiguration {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
		 		.apiInfo(metaData());
	}
	
	 private ApiInfo metaData() {
	        return new ApiInfoBuilder()

	                .title("Spring Boot REST API STATE")
	                .description("Spring Boot REST API for Compass / Hire me, please")
	                .version("1.0.0")
	                .license("Apache 2.0")
	                .contact(new Contact("Matheus Braynner", "https://github.com/Matheus-Braynner", "matheus.souza.pb@compasso.com.br"))
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
	                .build();
	    }
	}