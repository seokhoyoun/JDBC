package sche.model.service;

import java.sql.Connection;

import common.JDBCTemp;
import sche.model.dao.ScheduleDao;
import sche.model.vo.Schedule;

public class ScheduleService {
	
	private ScheduleDao dao = new ScheduleDao(); 

	public int addSchedule(String index, Schedule sd) {
			Connection conn = JDBCTemp.getConnection();
			int result = dao.addSchedule(conn, sd, index);
				if(result <= 0)
					JDBCTemp.rollback(conn);
				else
					JDBCTemp.commit(conn);
				JDBCTemp.close(conn);
					
		return result;
	}

}
