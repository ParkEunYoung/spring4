package com.spring4.chap07.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring4.chap07.Calculator;
import com.spring4.chap07.ImpeCalculator;

public class MainXmlPojo {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopPojo.xml");
		
//		Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
		ImpeCalculator impeCal = ctx.getBean("impeCal",ImpeCalculator.class);
		
		long fiveFact1 = impeCal.factorial(5);
		System.out.println("impeCal.factorial(5) = " + fiveFact1);
		
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		long fiveFact2 = recCal.factorial(5);
		System.out.println("recCal.factorial(5) = " + fiveFact2);
	}
}
