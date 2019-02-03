package model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemp.*;
import model.dao.AccountDao;
import exception.BankException;
import model.vo.Account;

public class AccountService {
	
	private AccountDao ad = new AccountDao();

	public int createUser(Account account) throws BankException {
		Connection conn = getConnection();
		int result = ad.createUser(conn, account);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public boolean checkID(String id) {
		Connection conn = getConnection();
		return ad.checkID(conn, id);
	}

	public ArrayList<Account> logIn(String id, String pwd) throws BankException {
		Connection conn = getConnection();
		ArrayList<Account> list = ad.logIn(conn,id,pwd);
		return list;
	}

	public int deposit(Account acc) throws BankException {
		Connection conn = getConnection();
		int result = ad.deposit(conn, acc);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public int withdraw(Account acc) throws BankException {
		Connection conn = getConnection();
		int result = ad.withdraw(conn, acc);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public Account checkRcc(String rccNum) {
		Connection conn = getConnection();
		Account rcc = ad.checkRcc(conn, rccNum);
		return rcc;
	}

	public ArrayList<Account> checkAcc(Account acc) {
		Connection conn = getConnection();
		ArrayList<Account> list = ad.checkAcc(conn, acc); 
		return list;
	}

	

}
