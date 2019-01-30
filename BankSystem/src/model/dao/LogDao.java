package model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import exception.LogException;
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

	public int depositLog(Connection conn, Log log) {
		int result = 0;
		try(PreparedStatement ps = conn.prepareStatement(p.getProperty("deposit"))){
			ps.setString(1, log.getId());
			ps.setInt(2, log.getDeposit());
			ps.setString(3, log.getComment());
			result = ps.executeUpdate();
			if(result <= 0) {
				rollback(conn);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
