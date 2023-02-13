package com.microservice.compareportal.request;

public class ProductRequest {

	private String aProductId;
	private String fProductId;
	private String productName;
	private double productPrice;

	public ProductRequest() {
		super();
	}

	public ProductRequest(String aProductId, String fProductId, String productName, double productPrice) {
		super();
		this.aProductId = aProductId;
		this.fProductId = fProductId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getaProductId() {
		return aProductId;
	}

	public void setaProductId(String aProductId) {
		this.aProductId = aProductId;
	}

	public String getfProductId() {
		return fProductId;
	}

	public void setfProductId(String fProductId) {
		this.fProductId = fProductId;
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
