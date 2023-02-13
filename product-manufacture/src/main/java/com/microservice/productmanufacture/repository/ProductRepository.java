package com.microservice.productmanufacture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.productmanufacture.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
