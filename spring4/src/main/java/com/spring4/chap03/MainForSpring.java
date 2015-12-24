package com.spring4.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException{
		
//		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
//		1. 두개의 xml을 사용할 경우
//		String[] conf={"classpath:conf1.xml", "classpath:conf2.xml"};
//		ctx = new GenericXmlApplicationContext(conf);
		
//		2.<import> 태그를 사용할 경우
		String[] conf={"classpath:configImport.xml"};
		ctx = new GenericXmlApplicationContext(conf);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")){
				System.out.println("종료합니다.");
				break;
			}
			if(command.startsWith("new")){
				processNewCommand(command.split(" "));
				//new abc@abc.com 박은영 123 123
				continue;
			}else if(command.startsWith("change")){
				processChangeCommand(command.split(" "));
				//change abc@abc.com 123 1234
				continue;
			}else if(command.startsWith("list")){
				processListCommand();
				//new korea@korea.com pey 1234 1234
				continue;
			}else if(command.startsWith("info")){
				processInfoCommand(command.split(" "));
				continue;
			}else if(command.startsWith("version")){
				processVersionCommand();
				continue;
			}
			printHelp();
		}
	}

	private static Assembler assembler = new Assembler();

	private static void processNewCommand(String[] args){
		
		if(args.length != 5){
			printHelp();
			return;
		}
		
//		MemberRegisterService regSvc = assembler.getMemberRegisterService();
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);

		if(!req.isPasswordEqualToConfirmPassword()){
			System.out.println("암호와 확인이 일치하지 않습니다.");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.");
		} catch (Exception e) {
			System.out.println("이미 존재하는 이메일 입니다.\n");
		}
	}

	private static void processChangeCommand(String[] args){
		if(args.length != 4){
			printHelp();
			return;
		}

//		ChangePasswordService changePwdSvc = assembler.getChangePasswordService();//
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc",ChangePasswordService.class);

		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("암호를 변경하였습니다.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일 입니다.\n");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
	}
	
	private static void printHelp(){
		System.out.println("===================Help==================");
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("info 이메일");
		System.out.println("=========================================");
	}
	
	private static void processListCommand(){
		MemberListPrinter listPrinter = ctx.getBean("listPrinter",MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommand(String args[]){
		if(args.length!=2){
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(args[1]);
	}
	
	private static void processVersionCommand(){
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
}
