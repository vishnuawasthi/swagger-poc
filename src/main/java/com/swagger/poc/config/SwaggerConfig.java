package com.swagger.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.alternates.AlternateTypeProvider;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@EnableSwagger
public class SwaggerConfig {

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(springSwaggerConfig)
		//.alternateTypeProvider(new AlternateTypeProvider())
		.apiInfo(apiInfo())
		.includePatterns("/api/*"); // assuming

	}

	
	public SpringSwaggerConfig springSwaggerConfig(){
		SpringSwaggerConfig config = new SpringSwaggerConfig();
	
		return config;
		
	}
	
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("My Project's REST API",
				"This is a description of your API.", 
				"API TOS",
				"me@wherever.com", 
				"API License", 
				"API License URL");
		return apiInfo;
	}

	public SpringSwaggerConfig getSpringSwaggerConfig() {
		return springSwaggerConfig;
	}

	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

}
