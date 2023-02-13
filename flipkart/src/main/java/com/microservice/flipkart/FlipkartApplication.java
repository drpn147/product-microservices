package com.microservice.flipkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients("com.microservice.flipkart")
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Flipkart API", version = "1.0", description = "Microservice demo"))
public class FlipkartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipkartApplication.class, args);
	}

}
