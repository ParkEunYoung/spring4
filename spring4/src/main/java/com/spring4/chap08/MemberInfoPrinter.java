package com.spring4.chap08;

public class MemberInfoPrinter {

	private MemberDao memDao;
	private MemberPrinter printer;
	
	//<property name="memberDao" ref="memberDao">
	public void setMemberDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email){
		Member member = memDao.selectByEmail(email);
		if(member == null){
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}
