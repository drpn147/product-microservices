package com.microservice.flipkart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "key-constant")
public interface FKeyConstantProxy {

	@GetMapping("/api/key-constant/displayByName")
	Object getKeyCurrentValue(@RequestParam(name = "key-name") String keyName);
}
