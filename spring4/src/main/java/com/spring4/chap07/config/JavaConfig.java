package com.spring4.chap07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.spring4.chap07.Calculator;
import com.spring4.chap07.RecCalculator;
import com.spring4.chap07.aspect.ExeTimeAspect2;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
	
	@Bean
	public ExeTimeAspect2 exeTimeAspect(){
		return new ExeTimeAspect2();
	}
	
	@Bean
	public Calculator recCal(){
		return new RecCalculator();
	}
}
