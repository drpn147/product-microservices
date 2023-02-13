package com.microservice.compareportal.model;

public class Product {

	private String productId;
	private String productName;
	private double productPrice;
	private String applicationName;

	public Product() {
		super();
	}

	public Product(String productId, String productName, double productPrice, String applicationName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.applicationName = applicationName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
