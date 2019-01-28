package employee.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import employee.model.dao.EmployeeDao;
import employee.model.vo.Employee;
import static common.JDBCTemplate.*; 
// Connection 관리와 트랜잭션 처리가 주 목적이다.
public class EmployeeService {
	
	//DI
	private EmployeeDao edao = new EmployeeDao(); 
	
	public EmployeeService() {
	}

	public HashMap<String,Employee> selectMap() {
		Connection conn = getConnection();
		HashMap<String, Employee> hm = edao.selectMap(conn);
		close(conn);
		return hm;
	}

	public Employee selectOne2(String empid) {
		Connection conn = getConnection();
		Employee emp = edao.selectOne(conn, empid);
		return emp;
	}
	

	public HashMap<String,Employee> selectJobMap(String jobid) {
		Connection conn = getConnection();
		HashMap<String,Employee> hm = edao.selectJobMap(conn, jobid);
		return hm;
	}

	public HashMap<String, Employee> selectDeptMap(String deptid) {
		Connection conn = getConnection();
		HashMap<String, Employee> hm = edao.selectDeptMap(conn, deptid);
		return hm;
	}

	public int insert2(Employee emp) {
		Connection conn = getConnection();
		int result = edao.insert(conn, emp);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updatePhone(Employee emp) {
		Connection conn = getConnection();
		int result = edao.updatePhone(conn, emp);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteEmp(String empid) {
		Connection conn = getConnection();
		int result = edao.deleteEmp(conn, empid);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateBonusPct(Employee emp) {
		Connection conn = getConnection();
		int result = edao.updateBonusPct(conn, emp);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	
}
