package com.microservice.amazon.response;

import java.util.List;

import com.microservice.amazon.request.AmazonRequest;

public class AmazonResponse {
	private int port;
	private String applicationName;
	List<AmazonRequest> productRequest;

	public AmazonResponse() {

	}

	public AmazonResponse(int port, String applicationName, List<AmazonRequest> productRequest) {
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

	public List<AmazonRequest> getProductRequest() {
		return productRequest;
	}

	public void setProductRequest(List<AmazonRequest> productRequest) {
		this.productRequest = productRequest;
	}

}
