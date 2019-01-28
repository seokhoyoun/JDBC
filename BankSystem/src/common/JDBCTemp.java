package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemp {
	
	
	
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties p = new Properties();
		try {
			p.load(new BufferedReader(new FileReader("prop/driver.properties")));
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
				
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
