package com.microservice.flipkart.dto;

public class FlipkartDto {
	private int fProductId;
	private int prodManufId;
	private String fProductName;
	private double fProductPrice;
	
	public FlipkartDto() {
		
	}
	
	
	public FlipkartDto(int fProductId, int prodManufId, String fProductName, double fProductPrice) {
		super();
		this.fProductId = fProductId;
		this.prodManufId = prodManufId;
		this.fProductName = fProductName;
		this.fProductPrice = fProductPrice;
	}


	public int getfProductId() {
		return fProductId;
	}
	public void setfProductId(int fProductId) {
		this.fProductId = fProductId;
	}
	public int getProdManufId() {
		return prodManufId;
	}
	public void setProdManufId(int prodManufId) {
		this.prodManufId = prodManufId;
	}
	public String getfProductName() {
		return fProductName;
	}
	public void setfProductName(String fProductName) {
		this.fProductName = fProductName;
	}
	public double getfProductPrice() {
		return fProductPrice;
	}
	public void setfProductPrice(double fProductPrice) {
		this.fProductPrice = fProductPrice;
	}
	
	
}
