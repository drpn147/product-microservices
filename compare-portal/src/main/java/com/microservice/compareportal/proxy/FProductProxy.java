package com.microservice.compareportal.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice.compareportal.response.ProductResponse;

@FeignClient(value="flipkart")
public interface FProductProxy {

	@GetMapping("/api/flipkart/displayAll")
	ProductResponse getAllFlipkartProduct();

}
