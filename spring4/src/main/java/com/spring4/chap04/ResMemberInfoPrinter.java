package com.spring4.chap04;

import javax.annotation.Resource;

public class ResMemberInfoPrinter {
	
	@Resource (name="memberDao")
    private MemberDao memDao;
    private MemberPrinter printer;

    public void setMemberDao(MemberDao memDao) {
        this.memDao = memDao;
    }

    @Resource (name="memberPrinter")
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
