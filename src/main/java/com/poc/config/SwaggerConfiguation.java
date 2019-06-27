package com.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
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
public class SwaggerConfiguation {

	@Autowired
	ApplicationConfigurationLoader CONFIG;

	// SWAGGER 2.0 INITIATION

			// DOCKET FOR ACCTOMER MANAGEMENT API
			@Bean
			public Docket ACCTomerManagementApi() {
				return new Docket(DocumentationType.SWAGGER_2)
						.groupName("ELIGIBILITY-CHECK").select()
						.apis(RequestHandlerSelectors.any())
						.paths(PathSelectors.ant("/ELIGIBILITY-CHECK/V1.0/**")).build()
						.apiInfo(accountManagementMetaData());
			}
		


			
			

			//ACCOUNT MANAGEMENT METADATA
			private ApiInfo accountManagementMetaData() {
				ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
				apiInfoBuilder
						.title(CONFIG.API_TITLE)
						.description(CONFIG.API_DESCRIPTION)
						.contact(
								new Contact(CONFIG.API_CONTACT_NAME, "",
										CONFIG.API_CONTACT_EMAIL))
						.version(CONFIG.API_VERSION)
						.termsOfServiceUrl(CONFIG.API_TERMS_SERVICE_URL)
						.license(CONFIG.API_LICENSE)
						.licenseUrl(CONFIG.API_LICENSE_URL);
		
				return apiInfoBuilder.build();
			}
			
			
}
