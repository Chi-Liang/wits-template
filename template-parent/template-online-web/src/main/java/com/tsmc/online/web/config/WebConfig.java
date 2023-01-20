package com.tsmc.online.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig {
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		 return new WebMvcConfigurer() {
	            public void addCorsMappings(CorsRegistry registry) {
	            	
	                registry.addMapping("/**")
	                        .allowCredentials(true)
	                        .allowedOrigins("http://localhost:8082")
	                        .maxAge(3600)
	                        .allowedMethods("GET", "POST", "PUT", "DELETE");
	                
	            }
	        };
    }
	
}
