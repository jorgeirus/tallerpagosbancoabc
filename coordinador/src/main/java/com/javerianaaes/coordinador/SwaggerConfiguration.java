package com.javerianaaes.coordinador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	 @Bean
	    public Docket coordinadorApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(coordinadorApiInfo())
	                .select()
	                .paths(coordinadorPaths())
	                .apis(RequestHandlerSelectors.any())
	                .build()
	                .useDefaultResponseMessages(false);
	    }


	    /**
	     * Api info
	     * @return ApiInfo
	     */
	    private ApiInfo coordinadorApiInfo() {
	        return new ApiInfoBuilder()
	                .title("Servicio Coordinador")
	                .version("1.0")
	                .license("Apache License Version 2.0")
	                .build();
	    }


	    /**
	     * Config paths.
	     *
	     * @return the predicate
	     */
	    private Predicate<String> coordinadorPaths() {
	        return PathSelectors.regex("/api/.*");
	}
}
