package com.microservice.productmanufacture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.productmanufacture.exception.DataNotFound;
import com.microservice.productmanufacture.request.ProductRequest;
import com.microservice.productmanufacture.response.ProductResponse;
import com.microservice.productmanufacture.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("save")
	public ResponseEntity<?> saveProduct(@RequestBody ProductRequest product) {
		try {
			ProductResponse response = productService.saveProduct(product);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (DataNotFound e) {
			throw new DataNotFound("Product not present in Product Manufacture DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("displayAll")
	public ResponseEntity<?> displayAllProduct() {
		try {
			ProductResponse response = productService.displayAllProduct();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (DataNotFound e) {
			throw new DataNotFound("Products not present in Product Manufacture DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("displayById")
	public ResponseEntity<?> displayProductById(@RequestParam(value = "product-id") Integer productId) {
		ProductResponse response = productService.displayProductById(productId);
		if (response == null) {
			throw new DataNotFound("Product with id: " + productId + " not present");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("deleteById")
	public ResponseEntity<?> deleteProductById(@RequestParam(value = "product-id") Integer productId) {
		ProductResponse response = productService.deleteProductById(productId);
		if (response == null) {
			throw new DataNotFound("Product with id: " + productId + " not present, uanble to delete");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
