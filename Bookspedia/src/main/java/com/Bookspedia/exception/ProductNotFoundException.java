package com.Bookspedia.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3006229460753837132L;
	private String message;

	public ProductNotFoundException() {

		this("Product is not available!!");
	}

	public ProductNotFoundException(String message) {

		this.message = System.currentTimeMillis()+":"+message;
	}
	
	public String getMessage() {
		return message;
	}

}
