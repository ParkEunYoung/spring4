package com.spring4.chap06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:springconf.xml");
		Client client = ctx.getBean("client", Client.class);
		client.send();
		ctx.close();
	}
}
