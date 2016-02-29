package com.spring4.chap05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig3 {
	
	@Bean
	public MemberDao memberDao(){
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc(MemberDao memDao){
		return new MemberRegisterService(memDao);
	}
	
	@Bean
	public MemberPrinter printer(){
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter(MemberDao memDao, MemberPrinter memPrt){
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memDao);
		infoPrinter.setPrinter(memPrt);
		return infoPrinter;
	}
}
