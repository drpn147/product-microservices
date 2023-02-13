package com.microservice.compareportal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microservice.compareportal.model.Product;
import com.microservice.compareportal.proxy.AProductProxy;
import com.microservice.compareportal.proxy.FProductProxy;
import com.microservice.compareportal.request.ProductRequest;
import com.microservice.compareportal.response.ComparePortalResponse;
import com.microservice.compareportal.response.ProductResponse;
import com.microservice.compareportal.service.ComparePortalService;

@Service
public class ComparePortalServiceImpl implements ComparePortalService {

	@Autowired
	private AProductProxy aProxy;

	@Autowired
	private FProductProxy fProxy;

	@Value("${server.port}")
	private int port; 

	@Value("${spring.application.name}")
	private String applicationName;

	@Override
	public ComparePortalResponse minByPriceProduct() {
		ProductResponse aResponse = aProxy.getAllAmazonProduct();
		ProductResponse fResponse = fProxy.getAllFlipkartProduct();
		List<Product> productRequest = filterByProductPrice(aResponse, fResponse);
		if (productRequest != null) {
			ComparePortalResponse response = new ComparePortalResponse();
			response.setApplicationName(applicationName);
			response.setPort(port);
			response.setProductList(productRequest);
			return response;
		}

		return null;
	}

	@Override
	public ComparePortalResponse displayAllProduct() {
		ProductResponse aResponse = aProxy.getAllAmazonProduct();
		ProductResponse fResponse = fProxy.getAllFlipkartProduct();
		if (aResponse != null || fResponse != null) {
			if (aResponse.getProductRequest() != null) {
				List<Product> aProductList = aResponse.getProductRequest().stream().map(req -> {
					Product aProduct = new Product();
					aProduct.setProductId(req.getaProductId());
					aProduct.setProductName(req.getProductName());
					aProduct.setProductPrice(req.getProductPrice());
					aProduct.setApplicationName(aResponse.getApplicationName());
					return aProduct;
				}).collect(Collectors.toList());
				List<Product> fProductList = fResponse.getProductRequest().stream().map(req -> {
					Product fProduct = new Product();
					fProduct.setProductId(req.getfProductId());
					fProduct.setProductName(req.getProductName());
					fProduct.setProductPrice(req.getProductPrice());
					fProduct.setApplicationName(fResponse.getApplicationName());
					return fProduct;
				}).collect(Collectors.toList());

				List<Product> productList = Stream.concat(aProductList.stream(), fProductList.stream())
						.collect(Collectors.toList());
				if (productList != null) {
					ComparePortalResponse response = new ComparePortalResponse();
					response.setPort(port);
					response.setApplicationName(applicationName);
					response.setProductList(productList);
					return response;
				}
			}
		}
		return null;
	}

	private List<Product> filterByProductPrice(ProductResponse aResponse, ProductResponse fResponse) {
		List<ProductRequest> aRequest = aResponse.getProductRequest();
		List<ProductRequest> fRequest = fResponse.getProductRequest();
		List<Product> request = new ArrayList<Product>();

		if (aRequest != null && fRequest != null && aRequest.size() > 0 && fRequest.size() > 0) {
			for (ProductRequest amazon : aRequest) {
				for (ProductRequest flipkart : fRequest) {
					if (amazon.getProductName().equalsIgnoreCase(flipkart.getProductName())) {
						if (amazon.getProductPrice() < flipkart.getProductPrice()) {
							Product product = new Product();
							product.setProductId(amazon.getaProductId());
							product.setProductName(amazon.getProductName());
							product.setProductPrice(amazon.getProductPrice());
							product.setApplicationName(aResponse.getApplicationName());
							request.add(product);
						} else if (amazon.getProductPrice() > flipkart.getProductPrice()) {
							Product product = new Product();
							product.setProductId(flipkart.getfProductId());
							product.setProductName(flipkart.getProductName());
							product.setProductPrice(flipkart.getProductPrice());
							product.setApplicationName(fResponse.getApplicationName());
							request.add(product);

						} else if (amazon.getProductPrice() == flipkart.getProductPrice()) {
							Product product = new Product();
							product.setProductId(amazon.getaProductId());
							product.setProductName(amazon.getProductName());
							product.setProductPrice(amazon.getProductPrice());
							product.setApplicationName(aResponse.getApplicationName());
							request.add(product);
						}
					}
				}
			}
		}

		return request;
	}

}
