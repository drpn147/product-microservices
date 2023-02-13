package com.microservice.keyconstant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Key Constant API", version = "1.0", description = "Microservice demo"))
public class KeyConstantApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyConstantApplication.class, args);
	}

}
