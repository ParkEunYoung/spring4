package com.spring4.chap04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	
	public static void main(String[] args){
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest reqReg = new RegisterRequest();
		reqReg.setName("eypark");
		reqReg.setEmail("abc@abc.com");
		reqReg.setPassword("1234");
		reqReg.setConfirmPassword("1234");
		regSvc.regist(reqReg);
		
		infoPrinter.printMemberInfo("abc@abc.com");
	}
}
