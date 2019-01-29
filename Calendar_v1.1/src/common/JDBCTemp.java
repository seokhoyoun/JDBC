package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemp {
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties p = new Properties(); 
		try {
			p.load(new BufferedReader(new FileReader("properties/driver.properties")));
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(!conn.isClosed() && conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(!stmt.isClosed() && stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(!rset.isClosed() && rset != null)
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(!conn.isClosed() && conn != null)
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(!conn.isClosed() && conn != null)
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
