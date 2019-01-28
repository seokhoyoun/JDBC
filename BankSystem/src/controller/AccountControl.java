package controller;

import model.service.AccountService;

public class AccountControl {

	private AccountService as = new AccountService();
	
	public void createUser() {
		int result = as.createUser();
	}

	
}
