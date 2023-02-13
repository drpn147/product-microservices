package com.microservice.keyconstant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.keyconstant.model.KeyConstant;
import com.microservice.keyconstant.repository.KeyConstantRepository;

@Service
public class KeyConstantServiceImpl implements KeyConstantService {

	private static Logger logger= LoggerFactory.getLogger(KeyConstantServiceImpl.class);
	
	@Autowired
	private KeyConstantRepository keyConstantRepo;

	@Override
	public String saveKeyValue(KeyConstant key) {
		String response = "Failed to save new key";
		if (key != null) {
			List<KeyConstant> keyList = displayAllKey();
			boolean result = false;
			for (KeyConstant k : keyList) {
				if (k.getKeyName().equals(key.getKeyName())) {
					result = true;
					keyConstantRepo.save(key);
				}
			}
			if (!result) {
				keyConstantRepo.save(key);
				response = "Successfully saved new key";
			}
		}
		return response;
	}

	@Override
	public List<KeyConstant> displayAllKey() {
		return keyConstantRepo.findAll();
	}

	@Override
	public Integer displayKeyByName(String keyName) {
		List<KeyConstant> keyList = displayAllKey();
		if (keyList != null) {
			for (KeyConstant key : keyList) {
				if (key.getKeyName().equals(keyName)) {
					key.setCurrentKeyCount(key.getCurrentKeyCount()+1);
					saveKeyValue(key);
					return key.getCurrentKeyCount();
				}
			}
		}
		return null;
	}

}
