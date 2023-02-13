package com.microservice.amazon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microservice.amazon.exception.DataNotFound;
import com.microservice.amazon.feign.AKeyConstantProxy;
import com.microservice.amazon.feign.AProductManufactureProxy;
import com.microservice.amazon.model.Amazon;
import com.microservice.amazon.repository.AmazonRepository;
import com.microservice.amazon.request.AmazonRequest;
import com.microservice.amazon.response.AmazonResponse;
import com.microservice.amazon.service.AmazonService;

@Service
public class AmazonServiceImpl implements AmazonService {

	@Value("${server.port}")
	int port;

	@Value("${spring.application.name}")
	String applicationName;

	@Autowired
	private AmazonRepository amazonRepo;

	@Autowired
	private AProductManufactureProxy aProxy;

	@Autowired
	private AKeyConstantProxy aKeyProxy;

	@Override
	public AmazonResponse addProduct() {
		try {
			AmazonResponse productResponse = aProxy.addProductFromManufacturer();
			String keyName = applicationName.toUpperCase().substring(0, 2);
			List<Amazon> existingAmazonProduct = amazonRepo.findAll();
			if (productResponse.getProductRequest() != null && productResponse.getProductRequest().size() > 0) {
				List<Amazon> newManufactureAmazonProduct = convertToAmazonObj(productResponse.getProductRequest());
				List<Amazon> removeDuplicateAmazonProduct = removeDuplicateProduct(newManufactureAmazonProduct,
						existingAmazonProduct);
				if (removeDuplicateAmazonProduct != null && removeDuplicateAmazonProduct.size() > 0) {
					List<Amazon> amazonProductList = new ArrayList<Amazon>();
					for (Amazon amazon : removeDuplicateAmazonProduct) {
						Object keyValue = aKeyProxy.getKeyCurrentValue(keyName);
						amazon.setProductId(keyName + keyValue);
						Double updatePrice = updateProductPrice(amazon.getProductPrice());
						amazon.setProductPrice(updatePrice);
						amazonProductList.add(amazon);
					}
					amazonRepo.saveAll(amazonProductList);
				}
			} else {
				throw new DataNotFound("No Product in Product manufacture DB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private List<Amazon> removeDuplicateProduct(List<Amazon> amazonList, List<Amazon> existingAmazonProduct) {
		for (Amazon a : existingAmazonProduct) {
			amazonList.removeIf(a1 -> a1.getProductName().equals(a.getProductName()));
		}
		return amazonList;
	}

	private List<Amazon> convertToAmazonObj(List<AmazonRequest> productRequest) {
		if (productRequest != null && productRequest.size() > 0) {
			List<Amazon> amazonProductList = productRequest.stream().map(req -> {
				Amazon amazon = new Amazon();
				amazon.setpManuId(req.getProductId());
				amazon.setProductName(req.getProductName());
				amazon.setProductPrice(req.getProductPrice());
				return amazon;
			}).collect(Collectors.toList());
			if (amazonProductList != null && amazonProductList.size() > 0) {
				return amazonProductList;
			}
		}
		return null;
	}

	private double updateProductPrice(double productPrice) {
		double result = 0;
		if (Double.compare(productPrice, 20000) <= 0) {
			result = productPrice + (productPrice * (21 / 100));
			return result;
		} else if (Double.compare(productPrice, 20000) > 0 && Double.compare(productPrice, 35000) <= 0) {
			result = productPrice + (productPrice * (19 / 100));
			return result;
		} else if (Double.compare(productPrice, 35000) > 0 && Double.compare(productPrice, 50000) <= 0) {
			result = productPrice + (productPrice * (16 / 100));
			return result;
		} else if (Double.compare(productPrice, 50000) > 0 && Double.compare(productPrice, 80000) <= 0) {
			result = productPrice + (productPrice * (14.95 / 100));
			return result;
		} else {
			result = productPrice + (productPrice * (12.75 / 100));
			return result;
		}
	}

	@Override
	public AmazonResponse displayAll() {
		List<Amazon> aProductList = amazonRepo.findAll();
		if (aProductList != null && aProductList.size() > 0) {
			List<AmazonRequest> aProductRequest = aProductList.stream().map(req -> {
				AmazonRequest aRequest = new AmazonRequest();
				aRequest.setaProductId(req.getProductId());
				aRequest.setProductId(req.getpManuId());
				aRequest.setProductName(req.getProductName());
				aRequest.setProductPrice(req.getProductPrice());
				return aRequest;
			}).collect(Collectors.toList());
			AmazonResponse aResponse = new AmazonResponse();
			aResponse.setPort(port);
			aResponse.setApplicationName(applicationName);
			aResponse.setProductRequest(aProductRequest);
			return aResponse;
		} else {
			throw new DataNotFound("Unavailable Amazon Product");
		}
	}

	@Override
	public AmazonResponse displayById(Integer productId) {
		try {

			Optional<Amazon> aProduct = amazonRepo.findById(productId);
			if (aProduct.isPresent()) {
				List<AmazonRequest> aProductRequest = aProduct.stream().map(req -> {
					AmazonRequest aRequest = new AmazonRequest();
					aRequest.setaProductId(req.getProductId());
					aRequest.setProductId(req.getpManuId());
					aRequest.setProductName(req.getProductName());
					aRequest.setProductPrice(req.getProductPrice());
					return aRequest;
				}).collect(Collectors.toList());
				AmazonResponse aResponse = new AmazonResponse();
				aResponse.setPort(port);
				aResponse.setApplicationName(applicationName);
				aResponse.setProductRequest(aProductRequest);
				return aResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AmazonResponse deleteById(Integer productId) {
		try {
			Optional<Amazon> aProduct = amazonRepo.findById(productId);
			if (aProduct.isPresent()) {
				amazonRepo.delete(aProduct.get());
				AmazonResponse aResponse = new AmazonResponse();
				aResponse.setPort(port);
				aResponse.setApplicationName(applicationName);
				aResponse.setProductRequest(null);
				return aResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
