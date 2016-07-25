package com.spring4.chap07.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring4.chap07.Calculator;
import com.spring4.chap07.config.JavaConfig;

public class MainJavaAspect {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		long fiveFact = recCal.factorial(5);
		System.out.println("recCal.factorial(5) = " + fiveFact);
	}
}
