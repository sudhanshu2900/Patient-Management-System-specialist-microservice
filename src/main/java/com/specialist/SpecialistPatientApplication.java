package com.specialist;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpecialistPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpecialistPatientApplication.class, args);
	}

	/**
	 * It return a prepared Docket instance
	 * select() provide the DocketBuilder object
	 * @return
	 */

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/specialists/*"))
				.apis(RequestHandlerSelectors.basePackage("com.specialist")).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Specialist API", "Api for project", "1.0.0","Free API",
				new springfox.documentation.service.Contact("Sudhanshu Gupta", "www.cognizant.com", "2125608@cognizant.com"),"API Licence","https://www.cognizant.com", Collections.emptyList());
	}
}
