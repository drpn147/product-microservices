package com.microservice.keyconstant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.keyconstant.model.KeyConstant;
import com.microservice.keyconstant.service.KeyConstantService;

@RestController
@RequestMapping("/api/key-constant")
public class KeyConstantController {

	@Autowired
	private KeyConstantService keyService;

	@PostMapping("save")
	public String saveKeys(@RequestBody KeyConstant key) {
		return keyService.saveKeyValue(key);
	}

	@GetMapping("displayAll")
	public List<KeyConstant> displayAll() {
		return keyService.displayAllKey();
	}

	@GetMapping("displayByName")
	public Integer displayByName(@RequestParam(name="key-name")String keyName) {
		return keyService.displayKeyByName(keyName);
	}

}
