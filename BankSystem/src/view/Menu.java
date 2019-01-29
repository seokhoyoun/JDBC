package view;

import java.util.Scanner;

import controller.AccountControl;
import model.vo.Account;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private AccountControl ac = new AccountControl(); 
	
	public void mainMenu() {
		while(true) {
		System.out.print("=======================\n"
				+ "1. 계정 생성 \n"
				+ "2. 로그인 하기 \n"
				+ "3. 프로그램 종료 \n"
				+ "번호 선택 : ");
		int mnum = sc.nextInt();
		switch(mnum) {
		case 1 : ac.createUser(putData()); break;
		case 2 : int result = ac.logIn(putID(),putPwd()); 
					if(result == 1) userMenu();
					else if(result == 2) managerMenu();
					else break;
		case 3 : return;
		}
	}
	}
	
	public void managerMenu() {
		
	}

	public void userMenu() {
		
	}

	public Account putData() {
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("주민 등록 번호 입력 : ");
		String ssN = sc.next();
		System.out.print("핸드폰 번호 입력 ['-'생략] : ");
		String phone = sc.next();
		System.out.print("아이디 입력 : ");
		String id;
		while(ac.checkID(id = sc.next())) { // true이면 아이디가 중복이다.
			System.out.println("중복 된 아이디 입니다.");
			System.out.print("아이디 입력 : ");
		}
		System.out.println("사용할 수 있는 아이디 입니다.");
		String password;
		while(true) {
		System.out.print("비밀번호 입력 : ");
		password = sc.next();
		System.out.print("비밀번호 재입력 : ");
		if(password.equals(sc.next()))
			break;
		System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		return new Account(ssN, phone, name, id, password);
	}
	
	private String putID() {
		System.out.print("아이디 입력 :");
		return sc.next();
	}
	private String putPwd() {
		System.out.print("패스워드 입력 : ");
		return sc.next();
	}
	
	
}
