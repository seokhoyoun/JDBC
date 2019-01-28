package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import book.mvc.view.BookMenu;

public class JDBCTemp {

	public static Connection getConnection() {
		Connection conn = null;
		Properties p = new Properties();
		try {
			p.load(new FileReader("prop/driver.properties"));
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
			conn.setAutoCommit(false);
			if(conn == null)
				new BookMenu().displayError("DB 연결 실패");
		} catch (Exception e) {
			new BookMenu().displayError(e.getMessage());
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
			} catch (SQLException e) {
				new BookMenu().displayError(e.getMessage());
			}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			} catch (SQLException e) {
				new BookMenu().displayError(e.getMessage());
			}
	}
	
	public static void close(ResultSet rset) {
			try {
				if(rset != null && !rset.isClosed())
				rset.close();
			} catch (SQLException e) {
				new BookMenu().displayError(e.getMessage());
			}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
			} catch (SQLException e) {
				new BookMenu().displayError(e.getMessage());
			}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
			} catch (SQLException e) {
				new BookMenu().displayError(e.getMessage());
			}
		
	}
	
	
}
