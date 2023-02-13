package com.microservice.productmanufacture.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "key-constant")
public interface KeyConstantProxy {

	@GetMapping("/api/key-constant/displayByName")
	Object addKeyConstantByName(@RequestParam(name = "key-name") String keyName);
}
 