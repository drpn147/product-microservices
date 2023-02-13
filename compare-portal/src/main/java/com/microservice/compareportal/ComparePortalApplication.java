package com.microservice.compareportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Comapare Portals API", version = "1.0", description = "Microservice demo"))
public class ComparePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComparePortalApplication.class, args);
	}

}
