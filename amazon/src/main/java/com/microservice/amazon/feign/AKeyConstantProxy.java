package com.microservice.amazon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "key-constant")
public interface AKeyConstantProxy {

	@GetMapping("/api/key-constant/displayByName")
	Object getKeyCurrentValue(@RequestParam(name = "key-name") String keyName);
}
