package controller;

import exception.BankException;
import model.service.AccountService;
import model.vo.Account;

public class AccountControl {

	private AccountService as;
	private LogControl lc;
	
	public AccountControl() {
		as = new AccountService();
		lc = new LogControl();
	}
	
	public void createUser(Account account) {
		try {
			int result = as.createUser(account);
			if(result > 0 )
				System.out.println("\n계정 생성을 완료하였습니다.");
		} catch (BankException e) {
			e.printStackTrace();
		}
	}

	public boolean checkID(String id) {
		return as.checkID(id);
	}

	public Account logIn(String id, String pwd) {
		Account acc = null;
		try {
			acc = as.logIn(id, pwd);
		} catch (BankException e) {
			e.printStackTrace();
		}
		return acc;
	}

	public void deposit(Account acc, int dMoney) {
		acc.setBal(acc.getBal()+dMoney);
		try {
			int result = as.deposit(acc);
			if(result > 0) {
				System.out.println(acc.getAccNumber()+"번 계좌번호에 "+dMoney+"원을 입금 성공했습니다");
				lc.depositLog(acc, dMoney);
			}
		} catch (BankException e) {
			e.printStackTrace();
		}
	}

	public void withdraw(Account acc, int wMoney) {
		if(wMoney > acc.getBal()) { System.out.println("잔액이 부족합니다"); return;} // 잔액보다 출금액이 많을 경우 리턴 처리
		acc.setBal(acc.getBal()- wMoney); // 출금
		int result = as.withdraw(acc);
			
	}

	

	
}
