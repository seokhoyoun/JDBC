package model.service;

import model.dao.LogDao;
import model.vo.Log;
import static common.JDBCTemp.*;

import java.sql.Connection;

import exception.LogException;
public class LogService {

	private LogDao ld;
	
	public LogService() throws LogException {
		ld = new LogDao();
	}

	public int depositLog(Log log) {
		Connection conn = getConnection();
		int result = ld.depositLog(conn, log);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public int withdrawLog(Log log) {
		Connection conn = getConnection();
		int result = ld.withdrawLog(conn, log);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

}
