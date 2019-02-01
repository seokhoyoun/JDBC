package model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import exception.LogException;
import model.vo.Account;
import model.vo.Log;
import static common.JDBCTemp.*;

public class LogDao {

	private Properties p = new Properties(); 
	
	public LogDao() throws LogException {
		try {
			p.load(new FileReader("prop/logquery.properties"));
		} catch (IOException e) {
			throw new LogException(e.getMessage());
		}
	}

	public int depositLog(Connection conn, Log log) throws LogException {
		int result = 0;
		try(PreparedStatement ps = conn.prepareStatement(p.getProperty("deposit"))){
			ps.setString(1, log.getId());
			ps.setInt(2, log.getDeposit());
			ps.setString(3, log.getComment());
			result = ps.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new LogException("\n입금 정보 저장에 문제가 발생했습니다.\n관리자에게 문의하세요");
			}
				
		} catch (SQLException e) {
			rollback(conn);
			throw new LogException(e.getMessage());
		}
		return result;
	}

	public int withdrawLog(Connection conn, Log log) throws LogException {
		int result = 0;
		try(PreparedStatement ps = conn.prepareStatement(p.getProperty("withdraw"))){
			ps.setString(1, log.getId());
			ps.setInt(2, log.getWithdraw());
			ps.setString(3, log.getComment());
			result = ps.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new LogException("\n출금 정보 저장에 문제가 발생했습니다.\n관리자에게 문의하세요");
			}
				
		} catch (SQLException e) {
			rollback(conn);
			throw new LogException(e.getMessage());
		}
		return result;
	}

	public int transferLog(Connection conn, Log log) throws LogException {
		int result = 0;
		try(PreparedStatement ps = conn.prepareStatement(p.getProperty("transfer"))){
			ps.setString(1, log.getId());
			ps.setString(2, log.getReceiverId());
			ps.setInt(3, log.getWithdraw());
			ps.setString(4, log.getComment());
			result = ps.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new LogException("\n송금 정보 저장에 문제가 발생했습니다.\n관리자에게 문의하세요");
			}
				
		} catch (SQLException e) {
			rollback(conn);
			throw new LogException(e.getMessage());
		}
		return result;
	}
	
	public ArrayList<Log> getDlog(Connection conn, Account acc) {
		ArrayList<Log> list = new ArrayList<>();
		PreparedStatement ps = null;
				ResultSet rs = null;
		
				try {
					ps = conn.prepareStatement(p.getProperty("getdlog"));
					ps.setString(1, acc.getId());
					rs = ps.executeQuery();
					while(rs.next()) {
						Log log = new Log();
						log.setId(rs.getString(1));
						log.setReceiverId(rs.getString(2));
						log.setExDate(rs.getDate(3));
						log.setDeposit(rs.getInt(4));
						log.setComment(rs.getString(7));
						
						list.add(log);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						rs.close();
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
		
		return list;
	}
	
	/*public ArrayList<Log> getDlog(Connection conn, Account acc) {
		ArrayList<Log> list = new ArrayList<>();
		try(PreparedStatement ps = createGetDlogPS(conn, acc, p.getProperty("getdlog"));
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Log log = new Log();
				log.setId(rs.getString(1));
				log.setReceiverId(rs.getString(2));
				log.setExDate(rs.getDate(3));
				log.setDeposit(rs.getInt(4));
				log.setComment(rs.getString(7));
				
				list.add(log);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private PreparedStatement createGetDlogPS(Connection conn, Account acc, String query) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		String id = acc.getId();
		ps.setString(1, id);
		return ps;
	}*/

}
