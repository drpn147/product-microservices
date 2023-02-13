 package com.microservice.productmanufacture.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microservice.productmanufacture.model.Product;
import com.microservice.productmanufacture.proxy.KeyConstantProxy;
import com.microservice.productmanufacture.repository.ProductRepository;
import com.microservice.productmanufacture.request.ProductRequest;
import com.microservice.productmanufacture.response.ProductResponse;
import com.microservice.productmanufacture.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Value("${server.port}")
	private int port;

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private KeyConstantProxy keyProxy;

	@Override
	public ProductResponse saveProduct(ProductRequest product) {

		ProductResponse response = new ProductResponse();
		String keyName=applicationName.toUpperCase().substring(0, 3);
		Object keyValue = keyProxy.addKeyConstantByName(keyName);
		try {
			if (product != null && keyValue != null) {
				Product saveProduct = new Product();
				saveProduct.setProductId(keyName+keyValue);
				saveProduct.setProductName(product.getProductName());
				saveProduct.setProductPrice(product.getProductPrice());
				productRepo.save(saveProduct);
				List<ProductRequest> productRequest = new ArrayList<ProductRequest>();
				productRequest.add(product);
				response.setPort(port);
				response.setApplicationName(applicationName);
				response.setProductRequest(productRequest);
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductResponse displayAllProduct() {
		List<Product> productList = productRepo.findAll();
		try {
			if (productList != null && !productList.isEmpty() && productList.size() > 0) {
				List<ProductRequest> productRequestList = new ArrayList<ProductRequest>();
				for (Product product : productList) {
					ProductRequest productRequest = new ProductRequest();
					productRequest.setProductId(product.getProductId());
					productRequest.setProductName(product.getProductName());
					productRequest.setProductPrice(product.getProductPrice());
					productRequestList.add(productRequest);
				}
				ProductResponse response = new ProductResponse();
				response.setPort(port);
				response.setApplicationName(applicationName);
				response.setProductRequest(productRequestList);
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductResponse displayProductById(Integer productId) {
		try {
			if (productId != null) {
				Optional<Product> product = productRepo.findById(productId);
				if (!product.isEmpty()) {
					List<ProductRequest> productRequestList = new ArrayList<ProductRequest>();
					productRequestList.add(new ProductRequest(product.get().getProductId(),
							product.get().getProductName(), product.get().getProductPrice()));
					ProductResponse response = new ProductResponse();
					response.setPort(port);
					response.setApplicationName(applicationName);
					response.setProductRequest(productRequestList);
					return response;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ProductResponse deleteProductById(Integer productId) {
		try {

			if (productId != null) {
				Optional<Product> product = productRepo.findById(productId);
				if (!product.isEmpty()) {
					productRepo.delete(product.get());
					ProductResponse response = new ProductResponse();
					response.setPort(port);
					response.setApplicationName(applicationName);
					response.setProductRequest(null);
					return response;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
