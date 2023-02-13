package com.microservice.amazon.exception;

public class DataNotFound extends RuntimeException{

	public DataNotFound(String m) {
		super(m);
	}
}
