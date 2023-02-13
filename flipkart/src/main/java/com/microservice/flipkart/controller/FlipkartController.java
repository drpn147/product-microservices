package com.microservice.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.flipkart.exception.DataNotFound;
import com.microservice.flipkart.response.FlipkartResponse;
import com.microservice.flipkart.service.FlipkartService;

@RestController
@RequestMapping("/api/flipkart")
public class FlipkartController {

	@Autowired
	private FlipkartService flipkartService;

	@GetMapping("save")
	public ResponseEntity<?> addFProduct() {
		try {
			FlipkartResponse response = flipkartService.addFProduct();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (DataNotFound e) {
			throw new DataNotFound("Product not present in ProductManufacture DB \n" + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("displayAll")
	public ResponseEntity<?> displayAllFProduct() {
		try {
			FlipkartResponse response = flipkartService.displayAllFProduct();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (DataNotFound e) {
			throw new DataNotFound("Product not present in Flipkart DB \n" + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("displayById")
	public ResponseEntity<?> displayFProductById(Integer fProductId) {
		FlipkartResponse response = flipkartService.displayFProductById(fProductId);
		if (response == null) {
			throw new DataNotFound("Product Not present");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("deleteById")
	public ResponseEntity<?> deleteFProductById(Integer fProductId) {
		FlipkartResponse response = flipkartService.deleteFProductById(fProductId);
		if (response == null) {
			throw new DataNotFound("Product not present, unable to delete");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
