package com.microservice.amazon.request;

public class AmazonRequest {
	private String aProductId;
	private String productId;
	private String productName;
	private double productPrice;

	public AmazonRequest() {
		super();
	}

	public AmazonRequest(String productId, String productName, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getaProductId() {
		return aProductId;
	}

	public void setaProductId(String aProductId) {
		this.aProductId = aProductId;
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

}
