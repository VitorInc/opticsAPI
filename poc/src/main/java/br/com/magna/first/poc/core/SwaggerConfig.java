package br.com.magna.first.poc.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	  private static final String BASE_PACKAGE = "br.com.magna.first.poc";
	    private static final String API_TITLE = "First poc requested by Augusto";
	    private static final String API_DESCRIPTION = "REST API for optics stock management";
	    private static final String CONTACT_NAME = "João Vitor";
	    private static final String CONTACT_GITHUB = "https://gtihub.com/VitorInc";
	    private static final String CONTACT_EMAIL = "joaocruz@magnasistemas.com";
	
	@Bean
	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.magna.first.poc"))
				.paths(PathSelectors.ant("/**"))
				.build();
	}
	
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version("1.0.0")
                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }
	

}
