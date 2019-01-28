package view;

import java.util.Scanner;

import controller.AccountControl;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private AccountControl ac = new AccountControl(); 
	
	public void mainMenu() {
		while(true) {
		System.out.print("======================="
				+ "1. 계정 생성 \n"
				+ "2. 로그인 하기 \n"
				+ "3. 프로그램 종료 \n"
				+ "번호 선택 : ");
		int mnum = sc.nextInt();
		switch(mnum) {
		case 1 : ac.createUser();
		case 2 :
		case 3 : return;
		}
	}
	}
	
}
