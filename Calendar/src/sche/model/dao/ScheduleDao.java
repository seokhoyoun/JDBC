package sche.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sche.model.vo.Schedule;

public class ScheduleDao {

	public int addSchedule(Connection conn, Schedule sd, String index) {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(index.substring(0, 4)).append("-").append(index.substring(4, 6)).append("-").append(index.substring(6));
		sd.setTime(Date.valueOf(sb.toString()));
		String query = "insert into tb_schedule values ( ?||LPAD( (select count(*) from tb_schedule where s_date = ?)+1 ,2 ,'0'), ? , ? , ? )";
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

}
