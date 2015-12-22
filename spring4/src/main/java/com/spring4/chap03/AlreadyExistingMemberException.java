package com.spring4.chap03;

public class AlreadyExistingMemberException extends RuntimeException{
	
	public AlreadyExistingMemberException(String message) {
		super(message);
	}
}
