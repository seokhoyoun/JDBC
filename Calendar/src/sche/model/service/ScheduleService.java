package sche.model.service;

import java.sql.Connection;

import common.JDBCTemp;
import sche.model.dao.ScheduleDao;
import sche.model.vo.Schedule;

public class ScheduleService {
	
	private ScheduleDao dao = new ScheduleDao(); 

	public int addSchedule(String index, Schedule schedule) {
			Connection conn = JDBCTemp.getConnection();
			int result = dao.addSchedule(conn, schedule, index);
				if(result <= 0)
					JDBCTemp.rollback(conn);
				else
					JDBCTemp.commit(conn);
				JDBCTemp.close(conn);
					
		return result;
	}

	public int modifySchedule(String index, Schedule schedule) {
		Connection conn = JDBCTemp.getConnection();
		int result = dao.modifySchedule(conn, schedule, index);
			if(result > 0 )
				JDBCTemp.commit(conn);
			else
				JDBCTemp.rollback(conn);
			JDBCTemp.close(conn);
		return result;
	}

}
