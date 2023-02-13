package com.microservice.flipkart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flipkart")
public class Flipkart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "f_product_id")
	private String fProductId;
	@Column(name = "pmanu_id")
	private String pManuId;
	@Column(name = "f_product_name")
	private String fProductName;
	@Column(name = "f_product_price")
	private double fProductPrice;

	public Flipkart() {

	}

	public Flipkart(String fProductName, double fProductPrice, String pManuId) {
		super();
		this.fProductName = fProductName;
		this.fProductPrice = fProductPrice;
		this.pManuId = pManuId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfProductId() {
		return fProductId;
	}

	public void setfProductId(String fProductId) {
		this.fProductId = fProductId;
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

	public String getpManuId() {
		return pManuId;
	}

	public void setpManuId(String pManuId) {
		this.pManuId = pManuId;
	}

}
