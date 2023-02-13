package com.microservice.compareportal.response;

import java.util.List;

import com.microservice.compareportal.request.ProductRequest;

public class ProductResponse {

	private int port;
	private int servicePort;
	private String applicationName;
	private List<ProductRequest> productRequest;
	
	public ProductResponse() {
		super();
	}

	public ProductResponse(int port, int servicePort, String applicationName, List<ProductRequest> productRequest) {
		super();
		this.port = port;
		this.servicePort = servicePort;
		this.applicationName = applicationName;
		this.productRequest = productRequest;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getServicePort() {
		return servicePort;
	}

	public void setServicePort(int servicePort) {
		this.servicePort = servicePort;
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
