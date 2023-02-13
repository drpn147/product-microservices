package com.microservice.flipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.flipkart.model.Flipkart;

public interface FlipkartRepository extends JpaRepository<Flipkart, Integer> {

}
