package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.AccountControl;
import controller.LogControl;
import model.vo.Account;
import model.vo.Log;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private AccountControl ac;
	private LogControl lc;
	
	public Menu() {
		ac = new AccountControl();
		lc = new LogControl(); 
	}
	
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
		case 2 : ArrayList<Account> list = ac.logIn(putID(),putPwd()); 
					if(list.isEmpty()) {System.out.println("로그인 실패"); break;}
					else if(!list.get(0).getId().equals("system")) {userMenu(list); break;}
					else {managerMenu(list); break;}
		case 3 : return;
		}
	}
	}
	
	private void managerMenu(ArrayList<Account> list) {
		System.out.println("관리자 메뉴 접속중...\n");
		while(true) {
			System.out.println("======================\n"
					+ "1. 전체 계좌 조회\n"
					+ "2. 계좌 검색\n"
					+ "3. 계좌 수정\n"
					+ "4. 계좌 삭제\n"
					+ "번호 입력 : ");
			int mnum = sc.nextInt();
			switch(mnum) {
			case 1 : printAcc(ac.searchAll());break;
			case 2 : printAcc(ac.searchKey(putKey()));break;
			case 3 : break;
			case 4 : break;
			}
		}
	}

	

	private void userMenu(ArrayList<Account> list) {
		System.out.println("\n사용자 메뉴 접속중...");
		while(true) {
			System.out.print("\n=================\n"
					+ "1. 내 계좌 조회 \n"
					+ "2. 입금하기 \n"
					+ "3. 출금하기 \n"
					+ "4. 송금하기 \n"
					+ "5. 거래내역 조회 \n"
					+ "6. 계좌 추가 생성 \n"
					+ "7. 로그아웃 하기\n"
					+ "번호 선택 : ");
			int mnum = sc.nextInt();
			
			switch(mnum) {
			case 1 : printAcc(list); break;
			case 2 : ac.deposit(chooseAcc(2,list), howMuch(2));  break;
			case 3 : ac.withdraw(chooseAcc(3,list), howMuch(3)); break;
			case 4 : Account rcc = putWho(); 
						if(sc.next().toLowerCase().charAt(0) == 'y') { ac.transfer(chooseAcc(4,list),rcc,howMuch(4)); break;} // 송금
						else break; // 안하면 다시 메뉴로 이동.
			case 5 : showDataMenu(chooseAcc(5,list)); break;
			case 6 :if(list.size() >= 3) {System.out.println("\n계좌 생성은 한 계정 당 3개 까지만 가능합니다."); break;}
					else {ac.createUser(list.get(0)); break;} 
			case 7 : return;
			}
		}
	}
	private void showDataMenu(Account acc) {
		System.out.print("===============\n"
				+ "1. 입금내역 조회\n"
				+ "2. 출금내역 조회\n"
				+ "3. 계좌 입/출금 내역 조회 \n"
				+ "4. 이전 메뉴로 돌아가기\n"
				+ "번호 입력 : ");
		int mnum = sc.nextInt();
		switch(mnum) {
		case 1 : printDlog(lc.getDlog(acc)); break;
		case 2 : printWlog(lc.getWlog(acc)); break;
		case 3 : printAllLog(lc.getAllLog(acc));break;
		case 4 : return;
		}
	}
	// 계좌 선택 메소드
	public Account chooseAcc(int num, List<Account> list) {
		System.out.println("==========================================");
		for(int i = 0; i < list.size(); i++) 
			System.out.println((i+1)+") 계좌 번호 : "+list.get(i).getAccNumber()+"\t잔액 : "+list.get(i).getBal()+"원\n");
		
		switch(num) {
		case 2 : System.out.print("입금하실 계좌를 선택하세요 : "); break;
		case 3 : System.out.print("출금하실 계좌를 선택하세요 : "); break;
		case 4 : System.out.print("송금하실 계좌를 선택하세요 : "); break;
		case 5 : System.out.print("조회하실 계좌를 선택하세요 : "); break;
		}
//		int index = sc.nextInt()-1;
		int index = 0;
		while((index = sc.nextInt()-1) >= list.size() || index < 0) 
			System.out.println("입력 값이 잘못되었습니다. 다시 선택해 주세요");
		return list.get(index);
	}
	
	
	// 출력 메소드
	private void printWlog(List<Log> list) {
		if(list.isEmpty())
			System.out.println("조회된 결과가 없습니다.");
		else {
			for(Log e : list) {
				System.out.println("\n출금 시간 : "+e.getExDate());
				System.out.println("출금 액 : "+ e.getWithdraw()+"원");
				if(e.getType() == 3) {
					String[] names = e.getComment().split("-");
					System.out.println("보낸 사람 : "+names[0]);
					System.out.println("받는 사람 : "+names[1]);
				}
			}
		}
	}
	
	private void printDlog(List<Log> list) {
		if(list.isEmpty())
			System.out.println("조회된 결과가 없습니다.");
		else {
			for(Log e : list) {
				System.out.println("입금 시간 : "+e.getExDate());
				System.out.println("입금 액 : "+ e.getDeposit()+"원 \n");
			}
		}
	}
	private void printAllLog(List<Log> list) {
		if(list.isEmpty())
			System.out.println("조회된 결과가 없습니다.");
		else {
			for(Log e : list) {
				System.out.println("======================================");
				if(e.getType() == 1) {
					System.out.println("입금 시간 : "+e.getExDate());
					System.out.println("입금 액 : "+ e.getDeposit()+"원 ");
				}
				else{
					System.out.println("출금 시간 : "+e.getExDate());
					System.out.println("출금 액 : "+ e.getWithdraw()+"원");
					if(e.getType() == 3) {
						String[] names = e.getComment().split("-");
						System.out.println("보낸 사람 : "+names[0]);
						System.out.println("받는 사람 : "+names[1]);
					}
				}
			}
			System.out.println("\n조회가 완료되었습니다.");
		}
	}
	

	private void printAcc(List<Account> list) {
		if(list.isEmpty())
			System.out.println("현재 생성된 계좌가 없습니다.");
		else {
			System.out.println("\n계좌번호 \t이름 \t잔액 \t개설날짜");
			for(int i = 0; i < list.size(); i++) {
				Account acc = list.get(i);
				System.out.println("==================================================");
				System.out.println(acc.getAccNumber()+"\t"+acc.getName()+"\t"+acc.getBal()+"원\t"+acc.getEstDate());
			}
		}
	}
	private String putKey() {
		System.out.print("검색어 입력 : ");
		return sc.next();
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
	
	private int howMuch(int num) {
		switch(num) {
		case 2 : System.out.print("\n입금하실 금액을 입력하세요 : "); break;
		case 3 : System.out.print("\n출금하실 금액을 입력하세요 : "); break;
		case 4 : System.out.print("\n송금하실 금액을 입력하세요 : "); break;
		}
		return sc.nextInt();
	}
	private Account putWho() {
		System.out.print("송금 할 계좌번호 입력 : ");
		Account rcc = ac.checkRcc(sc.next());
		if(rcc.getAccNumber() == null) 
			System.out.println("입력하신 계좌번호는 없는 번호입니다.");
		else 
			System.out.print(rcc.getName()+"님에게 송금하시겠습니까? (y/n) :");
		return rcc;
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
