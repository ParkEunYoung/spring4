package com.spring4.chap08;

public class AlreadyExistingMemberException extends RuntimeException{
	
	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
