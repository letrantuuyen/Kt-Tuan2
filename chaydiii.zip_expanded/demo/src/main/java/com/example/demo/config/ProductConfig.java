package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ProductConfig {
	
	@Bean
	public RestTemplate restemplate() {
		return new RestTemplate();
	}

}
