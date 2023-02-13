package com.microservice.compareportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.compareportal.response.ComparePortalResponse;
import com.microservice.compareportal.service.ComparePortalService;

@RestController
@RequestMapping("/api/compare-portal")
public class ComparePortalController {

	@Autowired
	private ComparePortalService productService;

	@GetMapping("displayAll")
	public ResponseEntity<?> displayAll() {
		ComparePortalResponse response = productService.displayAllProduct();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/minPriceProduct")
	public ResponseEntity<?> minPriceProduct() {
		ComparePortalResponse response = productService.minByPriceProduct();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
