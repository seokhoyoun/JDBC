package controller;

import model.exception.BankException;
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

	
}
