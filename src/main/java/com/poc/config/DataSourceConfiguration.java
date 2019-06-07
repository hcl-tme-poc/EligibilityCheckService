package com.poc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.poc.model")
@EnableJpaRepositories(basePackages={"com.poc.repository"})
public class DataSourceConfiguration {

	@Value("${app.prod.datasource.jdbcurl}")
	public String value;	

	
	// DEV DATASOURCE
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "app.dev.datasource")
	@Profile(value="DEV")
	public DataSource devDataSource() {
			return DataSourceBuilder.create().build();
	}
	
	
	// PROD DATASOURCE
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "app.prod.datasource")
	@Profile(value="PROD")
	public DataSource prodDataSource() {
			return DataSourceBuilder.create().build();
	}
}
