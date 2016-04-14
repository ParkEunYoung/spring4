package com.spring4.chap06;

import org.springframework.context.annotation.Bean;

public class JavaConfig {

	@Bean(initMethod="connect", destroyMethod="close")
	public Client2 client2(){
		Client2 client2 = new Client2();
		client2.setHost("서버2");
		return client2;
	}
}
