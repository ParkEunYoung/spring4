package com.spring4.chap05;

public class AlreadyExistingMemberException extends RuntimeException{
	
	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
