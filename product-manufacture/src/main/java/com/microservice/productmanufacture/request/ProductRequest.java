package com.microservice.productmanufacture.request;

public class ProductRequest {
	private String productId;
	private String productName;
	private double productPrice;

	public ProductRequest() {

	}

	public ProductRequest(String productId, String productName, double productPrice) {
		super();
		this.productId=productId;
		this.productName = productName;
		this.productPrice = productPrice;
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
