package com.bikkadit.curdopration.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	// spring security jwt token
	public ApiKey apikeys() {

		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	// spring security jwt token
	public List<SecurityContext> securityContexts() {
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}

	// spring security jwt token

	public List<SecurityReference> sf() {

		AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] { scope }));
	}

	// for swagger documentation
	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apikeys())) // takes list of apikeys()
				.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

	// swagger documentation
	private ApiInfo getInfo() {

		return new ApiInfo("Blogging Application  : Backend Course ", "This code is developed by NINAD THAKRE", "1.0",
				"Terms of services",
				new Contact("NINAD THAKRE", "http://ninadthakre010.com", "ninadthakre010@gmail.com"),
				"License of apis", "Api license URL", Collections.emptyList());
	}
}