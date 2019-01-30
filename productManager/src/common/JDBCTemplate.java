package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {
	
	
	public JDBCTemplate() {
	}
	
	public static Connection getConnection() {
		Properties p = new Properties();
		Connection conn = null;
		try {
			p.load(new FileReader("prop/dbserver.properties"));
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
