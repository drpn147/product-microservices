package com.microservice.productmanufacture.service;

import java.util.List;

import com.microservice.productmanufacture.request.ProductRequest;
import com.microservice.productmanufacture.response.ProductResponse;

public interface ProductService {

	ProductResponse saveProduct(ProductRequest product);

	ProductResponse displayAllProduct();

	ProductResponse displayProductById(Integer productId);

	ProductResponse deleteProductById(Integer productId);

}
