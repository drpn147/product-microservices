package com.microservice.flipkart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microservice.flipkart.exception.DataNotFound;
import com.microservice.flipkart.feign.FKeyConstantProxy;
import com.microservice.flipkart.feign.FProductManufactureProxy;
import com.microservice.flipkart.model.Flipkart;
import com.microservice.flipkart.repository.FlipkartRepository;
import com.microservice.flipkart.request.FlipkartRequest;
import com.microservice.flipkart.response.FlipkartResponse;
import com.microservice.flipkart.service.FlipkartService;

@Service
public class FlipkartServiceImpl implements FlipkartService {

	private final Logger logger = LoggerFactory.getLogger(FlipkartServiceImpl.class);

	@Value("${server.port}")
	private int port;

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private FlipkartRepository flipkartRepo;

	@Autowired
	private FProductManufactureProxy fProductProxy;

	@Autowired
	private FKeyConstantProxy fKeyProxy;

	@Override
	public FlipkartResponse addFProduct() {
		try {
			FlipkartResponse fResponse = fProductProxy.addAllFromProdManuf();
			String keyName = applicationName.toUpperCase().substring(0, 2);
			List<Flipkart> existingFlipkartProduct = flipkartRepo.findAll();
			if (fResponse.getProductRequest() != null && existingFlipkartProduct != null) {
				List<Flipkart> newManufacturerFlipkartProduct = convertToFlipkartObj(fResponse.getProductRequest());
				List<Flipkart> removeDuplicateFlipkartProduct = removeDuplicateProduct(newManufacturerFlipkartProduct,
						existingFlipkartProduct);
				if (removeDuplicateFlipkartProduct != null) {
					List<Flipkart> flipkartProductList = new ArrayList<Flipkart>();
					for (Flipkart flipkart : removeDuplicateFlipkartProduct) {
						Object keyValue = fKeyProxy.getKeyCurrentValue(keyName);
						flipkart.setfProductId(keyName + keyValue);
						Double productPrice = updateProductPrice(flipkart.getfProductPrice());
						flipkart.setfProductPrice(productPrice);
						flipkartProductList.add(flipkart);
					}
					flipkartRepo.saveAll(flipkartProductList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Flipkart> convertToFlipkartObj(List<FlipkartRequest> productRequest) {
		if (productRequest != null && productRequest.size() > 0) {
			List<Flipkart> newManufacturerFlipkartProduct = productRequest.stream().map(req -> {
				Flipkart product = new Flipkart();
				product.setfProductName(req.getProductName());
				product.setfProductPrice(req.getProductPrice());
				product.setpManuId(req.getProductId());
				return product;
			}).collect(Collectors.toList());
			if (newManufacturerFlipkartProduct != null && newManufacturerFlipkartProduct.size() > 0) {
				return newManufacturerFlipkartProduct;
			}
		}
		return null;
	}

	private List<Flipkart> removeDuplicateProduct(List<Flipkart> flipkartList, List<Flipkart> existingFlipkartProduct) {
		for (Flipkart f : existingFlipkartProduct) {
			flipkartList.removeIf(f1 -> f1.getfProductName().equals(f.getfProductName()));
		}
		return flipkartList;
	}

	@Override
	public FlipkartResponse displayAllFProduct() {
		try {

			List<Flipkart> productList = flipkartRepo.findAll();
			if (productList != null) {
				List<FlipkartRequest> productRequest = productList.stream().map(req -> {
					FlipkartRequest flipkartRequest = new FlipkartRequest();
					flipkartRequest.setProductId(req.getpManuId());
					flipkartRequest.setProductName(req.getfProductName());
					flipkartRequest.setProductPrice(req.getfProductPrice());
					flipkartRequest.setfProductId(req.getfProductId());
					return flipkartRequest;
				}).collect(Collectors.toList());
				FlipkartResponse flipkartResponse = new FlipkartResponse();
				flipkartResponse.setApplicationName(applicationName);
				flipkartResponse.setPort(port);
				flipkartResponse.setProductRequest(productRequest);
				return flipkartResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FlipkartResponse displayFProductById(Integer fProductId) {
		try {

			Optional<Flipkart> product = flipkartRepo.findById(fProductId);
			if (!product.isEmpty()) {
				List<FlipkartRequest> productRequest = product.stream().map(req -> {
					FlipkartRequest flipkartRequest = new FlipkartRequest();
					flipkartRequest.setfProductId(req.getfProductId());
					flipkartRequest.setProductId(req.getpManuId());
					flipkartRequest.setProductName(req.getfProductName());
					flipkartRequest.setProductPrice(req.getfProductPrice());
					return flipkartRequest;
				}).collect(Collectors.toList());

				FlipkartResponse flipkartResponse = new FlipkartResponse();
				flipkartResponse.setPort(port);
				flipkartResponse.setApplicationName(applicationName);
				flipkartResponse.setProductRequest(productRequest);
				return flipkartResponse;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public FlipkartResponse deleteFProductById(Integer fProductId) {
		try {

			Optional<Flipkart> fProduct = flipkartRepo.findById(fProductId);
			if (fProduct.get() != null) {
				flipkartRepo.delete(fProduct.get());
				FlipkartResponse fResponse = new FlipkartResponse();
				fResponse.setPort(port);
				fResponse.setApplicationName(applicationName);
				return fResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private double updateProductPrice(double getfProductPrice) {
		if (getfProductPrice != 0) {
			double result = 0;
			if (Double.compare(getfProductPrice, 20000) <= 0) {
				result = getfProductPrice + (getfProductPrice * (20 / 100));
				logger.info("update price: " + result);
				return result;
			} else if (Double.compare(getfProductPrice, 20000) > 0 && Double.compare(getfProductPrice, 35000) <= 0) {
				result = getfProductPrice + (getfProductPrice * (18 / 100));
				logger.info("update price: " + result);
				return result;
			} else if (Double.compare(getfProductPrice, 35000) > 0 && Double.compare(getfProductPrice, 50000) <= 0) {
				result = getfProductPrice + (getfProductPrice * (15 / 100));
				logger.info("update price: " + result);
				return result;
			} else if (Double.compare(getfProductPrice, 50000) > 0 && Double.compare(getfProductPrice, 80000) <= 0) {
				result = getfProductPrice + (getfProductPrice * (14.75 / 100));
				logger.info("update price: " + result);
				return result;
			} else {
				result = getfProductPrice + getfProductPrice * (12.5 / 100);
				logger.info("update price: " + result);
				return result;
			}
		} else {
			throw new DataNotFound("Invalid value");
		}
	}
}
