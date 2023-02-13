package com.microservice.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.amazon.model.Amazon;

@Repository
public interface AmazonRepository extends JpaRepository<Amazon, Integer> {

}
