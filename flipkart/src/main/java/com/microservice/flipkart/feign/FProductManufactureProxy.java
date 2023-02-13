package com.microservice.flipkart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice.flipkart.response.FlipkartResponse;

@FeignClient(name = "product-manufacture") 
public interface FProductManufactureProxy {

	@GetMapping("/api/product/displayAll")
	FlipkartResponse addAllFromProdManuf();
}
