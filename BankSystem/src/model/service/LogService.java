package model.service;

import model.dao.LogDao;
import model.vo.Account;
import model.vo.Log;
import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import exception.LogException;
public class LogService {

	private LogDao ld;
	
	public LogService() throws LogException {
		ld = new LogDao();
	}

	public int depositLog(Log log) throws LogException {
		Connection conn = getConnection();
		int result = ld.depositLog(conn, log);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public int withdrawLog(Log log) throws LogException {
		Connection conn = getConnection();
		int result = ld.withdrawLog(conn, log);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public int transfer(Log log) throws LogException {
		Connection conn = getConnection();
		int result = ld.transferLog(conn, log);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public ArrayList<Log> getDlog(Account acc) {
		Connection conn = getConnection();
		ArrayList<Log> list = ld.getDlog(conn, acc);
		return list;
	}

	public ArrayList<Log> getWlog(Account acc) {
		Connection conn = getConnection();
		ArrayList<Log> list = ld.getWlog(conn, acc);
		return list;
	}

	public ArrayList<Log> getAllLog(Account acc) {
		Connection conn = getConnection();
		ArrayList<Log> list = ld.getAllLog(conn, acc);
		return list;
	}

}
