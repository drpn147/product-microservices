package com.microservice.compareportal.response;

import java.util.List;

import com.microservice.compareportal.model.Product;

public class ComparePortalResponse {

	private int port;
	private String applicationName;
	private List<Product> productList;

	public ComparePortalResponse() {
		super();
	}

	public ComparePortalResponse(int port, String applicationName, List<Product> productList) {
		super();
		this.port = port;
		this.applicationName = applicationName;
		this.productList = productList;
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

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
