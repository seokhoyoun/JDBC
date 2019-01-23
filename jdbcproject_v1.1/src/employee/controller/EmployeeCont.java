package employee.controller;

import java.util.ArrayList;

import employee.model.dao.EmployeeDao;
import employee.model.vo.Employee;
import employee.view.EmployeeMenu;

public class EmployeeCont {
	private EmployeeDao edao = new EmployeeDao();
	
	public EmployeeCont() {
	}
	
	
	public ArrayList<Employee> selectAll() {
		ArrayList<Employee> empList = edao.selectList();
		if(empList.size() == 0) {
			System.out.println("\n직원 정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		return empList;
	}


	public Employee selectEmp(String empid) {
		Employee emp = edao.selectOne2(empid);
		if(emp == null) {
			System.out.println(empid+"사번 직원이 존재하지 않습니다.");
			new EmployeeMenu().displayMenu(); // 메뉴로가기. 좋은 방법은 아님.
		}
		
		return emp;
	}


	public ArrayList<Employee> selectJobid(String jobid) {
		ArrayList<Employee> list = edao.selectJobList(jobid);
		if(list.size() == 0) {
			System.out.println("\n해당 직급의 직원 정보가 없습니다.");
			new EmployeeMenu().displayMenu();
		}
		return list;
	}


	public ArrayList<Employee> selectDeptid(String deptid) {
		ArrayList<Employee> list = edao.selectDeptList(deptid);
		if(list.size() == 0) {
			System.out.println("\n해당 부서의 직원 정보가 없습니다.");
			new EmployeeMenu().displayMenu();
		}
		return list;
	}


	public void insertEmp(Employee emp) {
		int result = edao.insert(emp);
		
		if(result <= 0) {
			System.out.println("\n새 직원 등록 실패");
			System.out.println("확인하고 다시 시도해주세요.");
		}
		return;
	}
	
}
