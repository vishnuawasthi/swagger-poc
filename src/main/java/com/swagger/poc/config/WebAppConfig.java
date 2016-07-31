package com.swagger.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import com.mangofactory.swagger.configuration.SpringSwaggerConfig;

@Configuration
@EnableWebMvc
@Import(value=SwaggerConfig.class)
@ComponentScan(basePackages = { "com.swagger.poc.config", 
		"com.swagger.poc.controlller", 
		"com.swagger.poc.service",
		"com.swagger.poc.util" })
public class WebAppConfig extends WebMvcConfigurerAdapter {

	
	
	/*@Bean
	public SpringSwaggerConfig springSwaggerConfig(){
		SpringSwaggerConfig config = new SpringSwaggerConfig();
		return config;
	}*/
	
}
