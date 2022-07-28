package com.te.cardekho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CardekhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardekhoApplication.class, args);
	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry register) {
				register.addMapping("/**").allowedOrigins("*");
			}
		};

}
}
