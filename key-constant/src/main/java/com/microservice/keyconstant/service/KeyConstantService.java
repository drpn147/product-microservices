package com.microservice.keyconstant.service;

import java.util.List;

import com.microservice.keyconstant.model.KeyConstant;

public interface KeyConstantService {

	public String saveKeyValue(KeyConstant key);
	
	public List<KeyConstant> displayAllKey();
	
	public Integer displayKeyByName(String keyName);
}
