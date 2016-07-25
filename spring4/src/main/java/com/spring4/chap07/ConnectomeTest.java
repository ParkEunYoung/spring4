package com.spring4.chap07;

import java.util.regex.Pattern;

import org.junit.Test;

public class ConnectomeTest {

	@Test
	public static void main(String[] args) {
		
		String ipAddr = "10.10.10.123";
		String validIp = "^([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}$";		
		if(Pattern.matches(validIp, ipAddr)){
			System.out.println("success");
		}else
			System.out.println("fail");
	}

}
