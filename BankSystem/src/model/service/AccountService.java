package model.service;

import java.sql.Connection;

import common.JDBCTemp;
import model.dao.AccountDao;
import exception.BankException;
import model.vo.Account;

public class AccountService {
	
	private AccountDao ad = new AccountDao();

	public int createUser(Account account) throws BankException {
		Connection conn = JDBCTemp.getConnection();
		int result = ad.createUser(conn, account);
		if(result > 0)
			JDBCTemp.commit(conn);
		JDBCTemp.rollback(conn);
		return result;
	}

	public boolean checkID(String id) {
		Connection conn = JDBCTemp.getConnection();
		return ad.checkID(conn, id);
	}

	public int logIn(String id, String pwd) {
		Connection conn = JDBCTemp.getConnection();
		int result = ad.logIn(conn,id,pwd);
		return 0;
	}

}
