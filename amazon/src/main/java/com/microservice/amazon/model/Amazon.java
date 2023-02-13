package com.microservice.amazon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amazon")
public class Amazon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "a_product_id")
	private String productId;
	@Column(name = "a_product_name")
	private String productName;
	@Column(name = "a_product_price")
	private double productPrice;
	@Column(name = "pmanu_id")
	private String pManuId;

	public Amazon() {

	}

	public Amazon(String productId, String productName, double productPrice, String pManuId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.pManuId = pManuId;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getpManuId() {
		return pManuId;
	}

	public void setpManuId(String pManuId) {
		this.pManuId = pManuId;
	}

}
