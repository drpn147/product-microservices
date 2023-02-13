package com.microservice.compareportal.service;

import com.microservice.compareportal.response.ComparePortalResponse;

public interface ComparePortalService {

	ComparePortalResponse minByPriceProduct();

	ComparePortalResponse displayAllProduct();

}
