package employee.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import common.JDBCTemplate;
import employee.exception.EmployeeException;
import employee.model.vo.Employee;
//import common.JDBCTemplate;
import static common.JDBCTemplate.*;
//database access object
//jdbc 코드 : 비즈니스 로직
// 데이터베이스에대한 crud소스 구현
// create : insert - read : select - update : update - delete : delete 
public class EmployeeDao {
	// DI
	private Properties p = new Properties(); 
	
	public EmployeeDao() {
		try {
			p.load(new FileReader("properties/query.properties"));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	// 전체 직원 조회 처리용 메소드
	public HashMap<String, Employee> selectMap(Connection conn) throws EmployeeException {
		HashMap<String, Employee> hm = new HashMap<>(); 
		
		// 1. 드라이버 등록
		String query = p.getProperty("selectall");
		try (PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rset = stmt.executeQuery()){
			while(rset.next()) {
				Employee emp = new Employee();
				emp.setEmpid(rset.getString("emp_id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNO(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobid(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrid(rset.getString("mgr_id"));
				emp.setDeptid(rset.getString("dept_id"));
				
				hm.put(emp.getEmpid(), emp);
			}
			if(hm.size() == 0)
				throw new EmployeeException("조회된 정보가 존재하지 않습니다.");
			
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		return hm;
	}
	public Employee selectOne(Connection conn, String empid) throws EmployeeException {
		Employee emp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = p.getProperty("selectone");
		
		try {
			pstmt = conn.prepareStatement(query);
			//? 에 값 적용
			pstmt.setString(1, empid);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				emp = new Employee();
				emp.setEmpid(rset.getString("emp_id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNO(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobid(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrid(rset.getString("mgr_id"));
				emp.setDeptid(rset.getString("dept_id"));
			}
			if(emp == null)
				throw new EmployeeException(empid + "사번에 대한 직원 정보가 존재하지 않습니다.");
			
			
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return emp;
	}
	
	public Employee selectOne2(String empid) {
		
		Employee emp = null;
		String query = "select * from employee where emp_id = ?";
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
				PreparedStatement pstmt = conn.prepareStatement(query);){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			pstmt.setString(1, empid);
			try(ResultSet rset = pstmt.executeQuery()){
				if(rset.next()) {
					emp = new Employee();
					emp.setEmpid(rset.getString("emp_id"));
					emp.setEmpName(rset.getString("emp_name"));
					emp.setEmpNO(rset.getString("emp_no"));
					emp.setEmail(rset.getString("email"));
					emp.setPhone(rset.getString("phone"));
					emp.setHireDate(rset.getDate("hire_date"));
					emp.setJobid(rset.getString("job_id"));
					emp.setSalary(rset.getInt("salary"));
					emp.setBonusPct(rset.getDouble("bonus_pct"));
					emp.setMarriage(rset.getString("marriage"));
					emp.setMgrid(rset.getString("mgr_id"));
					emp.setDeptid(rset.getString("dept_id"));
			}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
		} 
		return emp;
	}
public Employee selectOne3(String empid) {
		
		Employee emp = null;
		
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
				PreparedStatement pstmt = createPS(conn,empid);
					ResultSet rset = pstmt.executeQuery()){
			Class.forName("oracle.jdbc.driver.OracleDriver");
				if(rset.next()) {
					emp = new Employee();
					emp.setEmpid(rset.getString("emp_id"));
					emp.setEmpName(rset.getString("emp_name"));
					emp.setEmpNO(rset.getString("emp_no"));
					emp.setEmail(rset.getString("email"));
					emp.setPhone(rset.getString("phone"));
					emp.setHireDate(rset.getDate("hire_date"));
					emp.setJobid(rset.getString("job_id"));
					emp.setSalary(rset.getInt("salary"));
					emp.setBonusPct(rset.getDouble("bonus_pct"));
					emp.setMarriage(rset.getString("marriage"));
					emp.setMgrid(rset.getString("mgr_id"));
					emp.setDeptid(rset.getString("dept_id"));
			}
		} catch (ClassNotFoundException | SQLException e) {
		} 
		return emp;
	}
	// StackOverFlow ver.
	private PreparedStatement createPS(Connection conn, String empid) throws SQLException {
		String query = "select * from employee where emp_id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, empid);
		return ps;
	}

	public HashMap<String, Employee> selectJobMap(Connection conn, String jobid) throws EmployeeException {
		HashMap<String, Employee> hm = new HashMap<>();
		String query = p.getProperty("selectjob");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, jobid);
			try(ResultSet rset = ps.executeQuery()){
			while(rset.next()) {
				Employee emp = new Employee();
				emp.setEmpid(rset.getString("emp_id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNO(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobid(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrid(rset.getString("mgr_id"));
				emp.setDeptid(rset.getString("dept_id"));
				
				hm.put(emp.getEmpid(), emp);
			}
			}
			if(hm.isEmpty())
				throw new EmployeeException("조회된 정보가 없습니다.");
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		return hm;
	}
	public HashMap<String, Employee> selectDeptMap(Connection conn, String deptid) throws EmployeeException {
		HashMap<String, Employee> hm = new HashMap<>();
		String query = p.getProperty("selectdept");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ps.setString(1, deptid);
			try(ResultSet rset = ps.executeQuery()){
				
			while(rset.next()) {
				Employee emp = new Employee();
				emp.setEmpid(rset.getString("emp_id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNO(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobid(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrid(rset.getString("mgr_id"));
				emp.setDeptid(rset.getString("dept_id"));
				hm.put(emp.getEmpid(), emp);
			}
			}
			if(hm.isEmpty())
				throw new EmployeeException(deptid+"에 대한 조회 정보가 없습니다.");
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		return hm;
	}
	public int insert(Connection conn, Employee emp) throws EmployeeException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = p.getProperty("insert");
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNO());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setDate(5, emp.getHireDate());
			pstmt.setString(6, emp.getJobid());
			pstmt.setInt(7, emp.getSalary());
			pstmt.setDouble(8, emp.getBonusPct());
			pstmt.setString(9, emp.getMarriage());
			pstmt.setString(10, emp.getMgrid());
			pstmt.setString(11, emp.getDeptid());
			/*EMP_ID
			EMP_NAME
			EMP_NO
			EMAIL
			PHONE
			HIRE_DATE
			JOB_ID
			SALARY
			BONUS_PCT
			MARRIAGE
			MGR_ID
			DEPT_ID*/
			result = pstmt.executeUpdate();
			if(result <= 0) {
				JDBCTemplate.rollback(conn);
				throw new EmployeeException("직원 정보 추가에 실패하였습니다.");
			}
			
		}catch (Exception e) {
			JDBCTemplate.rollback(conn);
			throw new EmployeeException(e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insert2(Employee emp) throws EmployeeException {
		String query = "insert into employee values (empid_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		int result = 0;			
		
		try(Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
					PreparedStatement pstmt = conn.prepareStatement(query);){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn.setAutoCommit(false);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNO());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setDate(5, emp.getHireDate());
			pstmt.setString(6, emp.getJobid());
			pstmt.setInt(7, emp.getSalary());
			pstmt.setDouble(8, emp.getBonusPct());
			pstmt.setString(9, emp.getMarriage());
			pstmt.setString(10, emp.getMgrid());
			pstmt.setString(11, emp.getDeptid());
			result = pstmt.executeUpdate();
			 if(result > 0) 
				 conn.commit();
			 else
				conn.rollback();
			 
					
		}catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return result;
	}
//	private PreparedStatement createPS(Connection conn, Employee emp)
	
	public int updatePhone(Connection conn, Employee emp) throws EmployeeException {
		int result = 0;
		PreparedStatement stmt = null;
		String query = p.getProperty("updatep");
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getPhone());
			stmt.setString(2, emp.getEmpid());
			result = stmt.executeUpdate();
			if(result <= 0) {
				JDBCTemplate.rollback(conn);
				throw new EmployeeException("전화번호 수정에 실패했습니다.");
			}
			
		}catch (Exception e) {
			JDBCTemplate.rollback(conn);
			throw new EmployeeException(e.getMessage());
		}finally {
			close(stmt);
		}
		return result;
	}
	public int updateBonusPct(Connection conn, Employee emp) throws EmployeeException {
		int result = 0;
		String query = p.getProperty("updateb");
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setDouble(1, emp.getBonusPct());
				stmt.setString(2, emp.getEmpid());
				result = stmt.executeUpdate();
				if(result <= 0) {
					JDBCTemplate.rollback(conn);
					throw new EmployeeException(emp.getEmpid()+"의 보너스 포인트 수정을 실패했습니다.");
				}
				
			}catch (Exception e) {
				JDBCTemplate.rollback(conn);
				throw new EmployeeException(e.getMessage());
			}
	return result;
	}
	public int deleteEmp(Connection conn, String empid) throws EmployeeException {
		int result = 0;
		String query = p.getProperty("delete");
			try(PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setString(1, empid);
				result = stmt.executeUpdate();
				if(result <= 0) {
					JDBCTemplate.rollback(conn);
					throw new EmployeeException("직원 정보 삭제에 실패했습니다.");
				}
				
			}catch (Exception e) {
				JDBCTemplate.rollback(conn);
				throw new EmployeeException(e.getMessage());
			}
	return result;
	}
}
