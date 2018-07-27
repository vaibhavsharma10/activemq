package com.vaibhav.bean;

import java.io.Serializable;

public class Welcome implements Serializable{
	private static final long serialVersionUID = 1L;

	public Welcome(String message) {
		super();
		this.message = message;
	}

	private final String message;

	public String getMessage() {
		return message;	
	}

	@Override
	public String toString() {
		return "Welcome [message=" + message + "]";
	}
	
	
}
