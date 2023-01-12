package com.customexception;

public class InavlidChoiceException extends RuntimeException {
	private String message;
	
	public InavlidChoiceException(String message){
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
