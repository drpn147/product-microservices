package com.microservice.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.amazon.exception.DataNotFound;
import com.microservice.amazon.response.AmazonResponse;
import com.microservice.amazon.service.AmazonService;

@RestController
@RequestMapping("/api/amazon")
public class AmazonController {

	@Autowired
	private AmazonService amazonService;

	@GetMapping("addProduct")
	public ResponseEntity<?> addProduct() {
		try {

			AmazonResponse response = amazonService.addProduct();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("displayAll")
	public ResponseEntity<?> displayAll() {
		try {

			AmazonResponse response = amazonService.displayAll();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (DataNotFound e) {
			throw new DataNotFound("Product List not present");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("displayById")
	public ResponseEntity<?> displayById(@RequestParam(value = "product_id") Integer productId) {
		AmazonResponse response = amazonService.displayById(productId);
		if (response == null) {
			throw new DataNotFound("Product with id: " + productId + " not present");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("deleteById")
	public ResponseEntity<?> deleteById(@RequestParam(value = "product_id") Integer productId) {
		AmazonResponse response = amazonService.deleteById(productId);
		if (response == null) {
			throw new DataNotFound("Product with id: " + productId + " not present");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
