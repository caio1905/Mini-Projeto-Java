package com.produtos.ApiCaio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
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
public class SwaggerConfig {
	@Bean
	 public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(apis())              
	          .paths(PathSelectors.any())                          
	          .build()
	          .apiInfo(apiInfo());
	    	}
	    
	    private Predicate<RequestHandler> apis() {
	        return RequestHandlerSelectors.basePackage("com.produtos.ApiCaio");
	    	}
	    
	    private ApiInfo apiInfo() {

	        ApiInfo apiInfo = new ApiInfoBuilder()
	                .title ("API de Produtos")
	                .description ("Essa é a api para salvar produtos")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	                .termsOfServiceUrl("/service.html")
	                .version("1.0.0")
	                .contact(new Contact("Caio Cesar", "Caio.m49@gmail.com", "Obrigado pelo apoio"))
	                .build();

	        return apiInfo;
	    }
}
