package com.microservice.amazon.service;

import com.microservice.amazon.response.AmazonResponse;


public interface AmazonService {

	public AmazonResponse addProduct();

	public AmazonResponse displayAll();

	public AmazonResponse displayById(Integer productId);

	public AmazonResponse deleteById(Integer productId);

}
