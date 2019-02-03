package controller;

import java.util.ArrayList;
import java.util.List;

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

	public ArrayList<Account> logIn(String id, String pwd) {
		ArrayList<Account> list = null;
		try {
			list = as.logIn(id, pwd);
		} catch (BankException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deposit(Account acc, int dMoney) {
		acc.setBal(acc.getBal()+dMoney);
		try {
			int result = as.deposit(acc);
			if(result > 0) {
				System.out.println("\n"+acc.getAccNumber()+"번 계좌번호에 "+dMoney+"원을 입금했습니다");
				lc.depositLog(acc, dMoney);
			}
		} catch (BankException e) {
			e.printStackTrace();
		}
	}

	public void withdraw(Account acc, int wMoney) {
		if(wMoney > acc.getBal()) { System.out.println("잔액이 부족합니다"); return;} // 잔액보다 출금액이 많을 경우 리턴 처리
		acc.setBal(acc.getBal()- wMoney); // 출금
		int result;
		try {
			result = as.withdraw(acc);
			if(result > 0) {
				System.out.println("\n"+wMoney+"원을 출금했습니다.");
				lc.withdrawLog(acc, wMoney);
			}
		} catch (BankException e) {
			e.printStackTrace();
		}
			
	}

	public Account checkRcc(String rccNum) {
		Account rcc = as.checkRcc(rccNum);
		return rcc;
	}

	// 송금
	public void transfer(Account acc, Account rcc, int tMoney) {
		if(tMoney > acc.getBal()) { System.out.println("잔액이 부족합니다"); return;}
		acc.setBal(acc.getBal() - tMoney);
		rcc.setBal(rcc.getBal() + tMoney);
		try {
			int result1 = as.withdraw(acc);
			int result2 = as.deposit(rcc);
			if(result1 > 0 && result2 > 0) {
				System.out.println("\n"+rcc.getName()+"님에게 "+tMoney+"원을 송금했습니다.");
				lc.transferLog(acc,rcc,tMoney);
			}
		} catch (BankException e) {
			e.printStackTrace();
		}
	}

	public List<Account> checkAcc(Account acc) {
		ArrayList<Account> list = as.checkAcc(acc); 
		return list;
	}

	

	
}
