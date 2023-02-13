package com.microservice.productmanufacture.response;

import java.util.List;

import com.microservice.productmanufacture.request.ProductRequest;

public class ProductResponse {

	private int port;
	private String applicationName;
	private List<ProductRequest> productRequest;

	public ProductResponse() {

	}

	public ProductResponse(int port, String applicationName, List<ProductRequest> productRequest) {
		super();
		this.port = port;
		this.applicationName = applicationName;
		this.productRequest = productRequest;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public List<ProductRequest> getProductRequest() {
		return productRequest;
	}

	public void setProductRequest(List<ProductRequest> productRequest) {
		this.productRequest = productRequest;
	}

	

}
