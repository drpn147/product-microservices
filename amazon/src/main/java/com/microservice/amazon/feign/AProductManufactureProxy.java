package com.microservice.amazon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice.amazon.response.AmazonResponse;

@FeignClient(name = "product-manufacture")
public interface AProductManufactureProxy {

	@GetMapping("/api/product/displayAll")
	public AmazonResponse addProductFromManufacturer();
}
