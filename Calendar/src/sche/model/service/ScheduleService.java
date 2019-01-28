package sche.model.service;

import java.sql.Connection;
import java.util.ArrayList;

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

	public int delSchedule(String index) {
		Connection conn = JDBCTemp.getConnection();
		int result = dao.delSchedule(conn,index);
		if(result > 0)
			JDBCTemp.commit(conn);
		else
			JDBCTemp.rollback(conn);
		JDBCTemp.close(conn);
		return result;
	}

	public ArrayList<Schedule> printSchedule() {
		Connection conn = JDBCTemp.getConnection();
		ArrayList<Schedule> list = dao.printSchedule(conn);
		if(list.isEmpty())
			JDBCTemp.rollback(conn);
		else
			JDBCTemp.commit(conn);
		JDBCTemp.close(conn);
		return list;
	}

}
