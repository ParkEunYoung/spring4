package com.spring4.chap05;

import org.springframework.context.annotation.Bean;

public class SpringExtConfig extends JavaConfig{
	
	private MemberDao memberDaoBean;
	@Bean
	public MemberDao memberDao(){
		if(memberDaoBean == null){
			memberDaoBean = super.memberDao();
		}
		return memberDaoBean;
	}
	
	private MemberRegisterService memberRegSvcBean;
	@Bean
	public MemberRegisterService memberRegSvc(){
		if(memberRegSvcBean == null){
			memberRegSvcBean = super.memberRegSvc();
		}
		return memberRegSvcBean;
	}
	
	private MemberInfoPrinter infoPrinterBean;
	@Bean
	public MemberInfoPrinter infoPrinter(){
		if(infoPrinterBean == null){
			infoPrinterBean = super.infoPrinter();
		}
		return infoPrinterBean;
	}
}
