package com.microservice.keyconstant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.keyconstant.model.KeyConstant;

public interface KeyConstantRepository extends JpaRepository<KeyConstant, Integer> {

}
