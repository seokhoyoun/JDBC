package model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import common.JDBCTemp;
import exception.BankException;
import model.vo.Account;

public class AccountDao {

	private Properties p = new Properties();
	
	public AccountDao() {
		try {
			p.load(new BufferedReader(new FileReader("prop/query.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean checkID(Connection conn, String id) {
		boolean checker = true;
		String query = p.getProperty("checkid"); 
		try(PreparedStatement ps = createPS(conn, id, query);
				ResultSet rset = ps.executeQuery()){
			if(!rset.next())
				checker = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checker;
	}
	private PreparedStatement createPS(Connection conn, String id, String query) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		return ps;
	}
	public int createUser(Connection conn, Account account) throws BankException {
		int result = 0;
		String query = p.getProperty("createuser");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, account.getSsN());
			ps.setString(2, account.getName());
			ps.setString(3, account.getPhone());
			ps.setString(4, account.getId());
			ps.setString(5, account.getPassword());
			result = ps.executeUpdate();
			if(result <= 0) {
				JDBCTemp.rollback(conn);
				throw new BankException("계정 생성에 실패했습니다.");
			}
			
		} catch (SQLException e) {
			JDBCTemp.rollback(conn);
			throw new BankException(e.getMessage());
		}
		return result;
	}
	public int logIn(Connection conn, String id, String pwd) {
		int result = 0;
		String query = p.getProperty("login");
		try(PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rset = ps.executeQuery()){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	
	
}
