package com.microservice.productmanufacture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients("com.microservice.productmanufacture")
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Product-Manufacture API", version = "1.0", description = "microservice demo"))
public class ProductManufactureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManufactureApplication.class, args);
	}

}
