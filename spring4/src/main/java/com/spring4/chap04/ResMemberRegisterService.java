package com.spring4.chap04;

import java.util.Date;

import javax.annotation.Resource;

public class ResMemberRegisterService {

	@Resource(name="memberDao")
    private MemberDao memberDao;

    //@Autowired//생성자에 적용된 @Autowired 삭제
    public ResMemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    public ResMemberRegisterService() {
    
    }
    
    public void regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null){
			throw new AlreadyExistingMemberException("dup email" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}
