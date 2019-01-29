package controller;

import exception.BankException;
import model.service.AccountService;
import model.vo.Account;

public class AccountControl {

	private AccountService as = new AccountService();
	
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
			if(acc == null)
				System.out.println("로그인 실패");
		} catch (BankException e) {
			e.printStackTrace();
		}
		return acc;
	}

	public Account deposit(Account acc, int dMoney) {
		acc.setBal(acc.getBal()+dMoney);
		acc = as.deposit(acc);
		return acc;
	}

	

	
}
