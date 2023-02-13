package com.microservice.compareportal.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice.compareportal.response.ProductResponse;

@FeignClient(value="amazon")
public interface AProductProxy {
	
	@GetMapping("/api/amazon/displayAll")
	public ProductResponse getAllAmazonProduct();

}
