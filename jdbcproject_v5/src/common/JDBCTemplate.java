package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import employee.exception.EmployeeException;

// 싱글톤(Singleton) 디자인 패턴
// 프로그램 구동 내내 메모리에 한번만 기록되어서 사용된다.
// static 메모리를 사용하게 함.

public class JDBCTemplate {

	public static Connection getConnection() throws EmployeeException {
		Connection conn = null;
		Properties p = new Properties();
		
		try {
			p.load(new FileReader("properties/driver.properties"));
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
			conn.setAutoCommit(false);
		} catch(Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return conn;
	}
	
	public static void close(Connection conn) throws EmployeeException {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
	}
	
	public static void close(Statement stmt) throws EmployeeException {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
	}
	public static void close(ResultSet rset) throws EmployeeException {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
			} catch (SQLException e) {
				throw new EmployeeException(e.getMessage());
			}
	}
	
	public static void commit(Connection conn) throws EmployeeException {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
			} catch (SQLException e) {
				throw new EmployeeException(e.getMessage());
			}
			
		
	}
	
	public static void rollback(Connection conn) throws EmployeeException {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
			} catch (SQLException e) {
				throw new EmployeeException(e.getMessage());
			}
	}
}
