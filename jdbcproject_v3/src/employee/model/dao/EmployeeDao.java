package employee.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import employee.model.vo.Employee;
//import common.JDBCTemplate;
import static common.JDBCTemplate.*;
//database access object
//jdbc 코드 : 비즈니스 로직
// 데이터베이스에대한 crud소스 구현
// create : insert - read : select - update : update - delete : delete 
public class EmployeeDao {
	
	public EmployeeDao() {
	}
	// 전체 직원 조회 처리용 메소드
	public ArrayList<Employee> selectList(Connection conn) {
		ArrayList<Employee> empList = new ArrayList<>(); 
		
		// 1. 드라이버 등록
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from employee";
		try {
		// 2. 데이터베이스 연결
//			System.out.println("conn : "+ conn);
		// 3. 쿼리문 가지고 db에 가서 실행하고나서 결과 가지고 돌아오는 객체 생성
			stmt = conn.createStatement();
		// 4. 쿼리문 보내서 실행하고 결과받기
			rset = stmt.executeQuery(query);
		// 5. ResultSet에  조회해 온 결과 행들의 컬럼값들을 하나씩 꺼내서 변수|필드에 옮겨 담기
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
				
				empList.add(emp);
			}
		/*	EMP_ID	CHAR(3 BYTE)
			EMP_NAME	VARCHAR2(20 BYTE)
			EMP_NO	CHAR(14 BYTE)
			EMAIL	VARCHAR2(25 BYTE)
			PHONE	VARCHAR2(12 BYTE)
			HIRE_DATE	DATE
			JOB_ID	CHAR(2 BYTE)
			SALARY	NUMBER
			BONUS_PCT	NUMBER
			MARRIAGE	CHAR(1 BYTE)
			MGR_ID	CHAR(3 BYTE)
			DEPT_ID	CHAR(2 BYTE)*/
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return empList;
	}
	public Employee selectOne(Connection conn, String empid) {
		Employee emp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where emp_id = ?";
		
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
			
		} catch (Exception e) {
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

	public ArrayList<Employee> selectJobList(Connection conn, String jobid) {
		ArrayList<Employee> list = new ArrayList<>();
		String query = "select * from employee where job_id = ?";
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
				
				list.add(emp);
			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Employee> selectDeptList(Connection conn, String deptid) {
		ArrayList<Employee> list = new ArrayList<>();
		String query = "select * from employee where dept_id = ?";
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
				list.add(emp);
			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insert(Connection conn, Employee emp) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into employee values "
				+ "(empid_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
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
			
		}catch (Exception e) {
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insert2(Employee emp) {
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
		}
		
		return result;
	}
//	private PreparedStatement createPS(Connection conn, Employee emp)
	
	public int updatePhone(Connection conn, Employee emp) {
		int result = 0;
		Statement stmt = null;
		String query = "update employee set phone = '"+emp.getPhone()+"' where emp_id = '"+
						emp.getEmpid()+"'";
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return result;
	}
	public int updateBonusPct(Connection conn, Employee emp) {
		int result = 0;
		String query = "update employee set bonus_pct = "+emp.getBonusPct()+" where emp_id = '"+emp.getEmpid()+"'";
			try(Statement stmt = conn.createStatement();){
				result = stmt.executeUpdate(query);
				
			}catch (Exception e) {
			}
	return result;
	}
	public int deleteEmp(Connection conn, String empid) {
		int result = 0;
		String query = "delete employee where emp_id = '"+empid+"'";
			try(Statement stmt = conn.createStatement()){
				result = stmt.executeUpdate(query);
				
			}catch (Exception e) {
			}
	return result;
	}
}
