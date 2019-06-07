package com.poc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = { "com.poc.*"})
@EnableDiscoveryClient
@EnableFeignClients
public class EligibilityCheckServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EligibilityCheckServiceApplication.class, args);
	}
	
}
