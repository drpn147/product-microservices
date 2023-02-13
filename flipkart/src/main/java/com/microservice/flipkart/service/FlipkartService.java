package com.microservice.flipkart.service;

import com.microservice.flipkart.response.FlipkartResponse;

public interface FlipkartService {

	FlipkartResponse addFProduct();

	FlipkartResponse displayAllFProduct();

	FlipkartResponse displayFProductById(Integer fProductId);

	FlipkartResponse deleteFProductById(Integer fProductId);

}
