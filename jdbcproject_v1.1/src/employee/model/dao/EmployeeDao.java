package employee.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import employee.model.vo.Employee;

//database access object
//jdbc 코드 : 비즈니스 로직
// 데이터베이스에대한 crud소스 구현
// create : insert - read : select - update : update - delete : delete 
public class EmployeeDao {
	
	public EmployeeDao() {
	}
	// 전체 직원 조회 처리용 메소드
	public ArrayList<Employee> selectList() {
		ArrayList<Employee> empList = new ArrayList<>(); 
		
		// 1. 드라이버 등록
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from employee";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		// 2. 데이터베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
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
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}
	public Employee selectOne(String empid) {
		Employee emp = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where emp_id = '"+empid+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
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
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	
	public Employee selectOne2(String empid) {
		
		Employee emp = null;
		String query = "select * from employee where emp_id = '"+empid+"'";
		
		try(ResultSet rset = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student").createStatement().executeQuery(query)){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
			
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
	public ArrayList<Employee> selectJobList(String jobid) {
		ArrayList<Employee> list = new ArrayList<>();
		String query = "select * from employee where job_id = '"+jobid+"'";
		try(ResultSet rset = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student").createStatement().executeQuery(query)){
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Employee> selectDeptList(String deptid) {
		ArrayList<Employee> list = new ArrayList<>();
		String query = "select * from employee where dept_id = '"+deptid+"'";
		try(ResultSet rset = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student").createStatement().executeQuery(query)){
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insert(Employee emp) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String query = "insert into employee values "
				+ "(empid_seq.nextval,'"+emp.getEmpName()+"','"+emp.getEmpNO()+"','"+emp.getEmail()+"','"+emp.getPhone()+"','"+emp.getHireDate()+"','"+
				emp.getJobid()+"',"+emp.getSalary()+","+emp.getBonusPct()+", '"+emp.getMarriage()+"', '"+emp.getMgrid()+"', '"+emp.getDeptid()+"')";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			 if(result > 0) {
				 conn.commit();
			 }
			 else
				conn.rollback();
		}catch (Exception e) {
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int insert2(Employee emp) {
		// 수정중
		String query = "insert into employee values (empid_seq.nextval,'"+emp.getEmpName()+"','"+emp.getEmpNO()+"','"+emp.getEmail()+"','"+emp.getPhone()+"','"+emp.getHireDate()+"','"+
				emp.getJobid()+"',"+emp.getSalary()+","+emp.getBonusPct()+", '"+emp.getMarriage()+"', '"+emp.getMgrid()+"', '"+emp.getDeptid()+"')";
		int result = 0;			
		
		try(Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
					Statement stmt = conn.createStatement();){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn.setAutoCommit(false);
			result = stmt.executeUpdate(query);
			 if(result > 0) 
				 conn.commit();
			 else
				conn.rollback();
					
		}catch (Exception e) {
		}
		
		return result;
	}
	public int updatePhone(Employee emp) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		String query = "update employee set phone = '"+emp.getPhone()+"' where emp_id = '"+
						emp.getEmpid()+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateBonusPct(Employee emp) {
		int result = 0;
		String query = "update employee set bonus_pct = "+emp.getBonusPct()+" where emp_id = '"+emp.getEmpid()+"'";
			try(Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
				Statement stmt = conn.createStatement();){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn.setAutoCommit(false);
				result = stmt.executeUpdate(query);
					if(result > 0) 
						conn.commit();
					else
						conn.rollback();
				
			}catch (Exception e) {
			}
	return result;
	}
	public int deleteEmp(String empid) {
		int result = 0;
		String query = "delete employee where emp_id = '"+empid+"'";
			try(Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
				Statement stmt = conn.createStatement();){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn.setAutoCommit(false);
				result = stmt.executeUpdate(query);
					if(result > 0) 
						conn.commit();
					else
						conn.rollback();
				
			}catch (Exception e) {
			}
	return result;
	}
}
