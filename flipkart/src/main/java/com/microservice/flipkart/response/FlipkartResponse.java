package com.microservice.flipkart.response;

import java.util.List;

import com.microservice.flipkart.request.FlipkartRequest;
//import com.microservice.flipkart.request.FlipkartRequest;

public class FlipkartResponse {

	private int port;
	private String applicationName;
	List<FlipkartRequest> productRequest;

	public FlipkartResponse() {

	}

	public FlipkartResponse(int port, String applicationName, List<FlipkartRequest> productRequest) {
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

	public List<FlipkartRequest> getProductRequest() {
		return productRequest;
	}

	public void setProductRequest(List<FlipkartRequest> productRequest) {
		this.productRequest = productRequest;
	}

}
