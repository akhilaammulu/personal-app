package com.example.personal_finance_management_app.Config;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

public class SwaggerConfig {
	
	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	            .components(new Components().addSecuritySchemes("basicScheme",
	                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
	            .info(new Info().title("API Documentation").version("1.0"))
	            .addSecurityItem(new SecurityRequirement().addList("basicScheme"));
	    }

	    @Bean
	    public GroupedOpenApi api() {
	        return GroupedOpenApi.builder()
	            .group("my-custom-user-controller")
	            .pathsToMatch("/api/**")
	            .build();
	    }
	}


