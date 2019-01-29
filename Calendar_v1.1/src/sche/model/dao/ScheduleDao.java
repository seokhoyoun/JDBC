package sche.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import sche.model.vo.Schedule;

public class ScheduleDao {
	
	private Properties p = new Properties(); 
	
	public ScheduleDao() {
		try {
			p.load(new BufferedReader(new FileReader("properties/query.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int addSchedule(Connection conn, Schedule sd, String index) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(index.substring(0, 4)).append("-").append(index.substring(4, 6)).append("-").append(index.substring(6));
		sd.setTime(Date.valueOf(sb.toString()));
		String query = p.getProperty("insert");
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, index);
				ps.setDate(2, sd.getTime());
				ps.setString(3, sd.getTitle());
				ps.setDate(4, sd.getTime());
				ps.setString(5, sd.getContent());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		return result;
	}

	public int modifySchedule(Connection conn, Schedule schedule, String index) {
		int result = 0;
		String query = p.getProperty("modify");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, schedule.getTitle());
			ps.setString(2, schedule.getContent());
			ps.setString(3, index);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delSchedule(Connection conn, String index) {
		int result = 0;
		String query = p.getProperty("delete");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, index);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Schedule> printSchedule(Connection conn) {
		ArrayList<Schedule> list = new ArrayList<>();
		
		String query = p.getProperty("selectall");
		try(PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Schedule sche = new Schedule();
				sche.setId(rs.getString("s_id"));
				sche.setTitle(rs.getString("title"));
				sche.setTime(rs.getDate("s_date"));
				sche.setContent(rs.getString("s_content"));
				list.add(sche);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
