package com.spring4.chap04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main5 {

public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");
		ResMemberRegisterService resRegSvc = ctx.getBean("resMemberRegSvc", ResMemberRegisterService.class);
		ResMemberInfoPrinter resInfoPrinter = ctx.getBean("resInfoPrinter", ResMemberInfoPrinter.class);
	}
}
