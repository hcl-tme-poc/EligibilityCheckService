package com.poc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:${config.props.path}/app-config.properties"),
	@PropertySource("classpath:${config.props.path}/swagger-config.properties")
})
public class ApplicationConfigurationLoader {
	
	/**
	 *********** SWAGGER PROPERTIES***********
	 */
	@Value("${api.title}")
	public String API_TITLE;
	
	@Value("${api.description}")
	public String API_DESCRIPTION;
	
	@Value("${api.contact.name}")
	public String API_CONTACT_NAME;
	
	@Value("${api.contact.email}")
	public String API_CONTACT_EMAIL;
	
	@Value("${api.version}")
	public String API_VERSION;
	
	@Value("${api.terms_of_service_url}")
	public String API_TERMS_SERVICE_URL;
	
	@Value("${api.license}")
	public String API_LICENSE;
	
	@Value("${api.license_url}")
	public String API_LICENSE_URL;	
	
	
	


	
	/**
	 ***************APPLICATION PROPERTIES****************
	 */

	

}
