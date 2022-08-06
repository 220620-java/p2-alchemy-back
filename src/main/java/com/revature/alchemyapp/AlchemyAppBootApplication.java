package com.revature.alchemyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AlchemyAppBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(AlchemyAppBootApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfig() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
					.allowedOrigins("null")
					.allowedHeaders("*")
					.exposedHeaders("Auth")
					.allowCredentials(false);
			}
		};
	}


}
