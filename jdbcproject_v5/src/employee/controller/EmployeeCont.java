package employee.controller;

import java.util.HashMap;

import employee.exception.EmployeeException;
import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import employee.view.EmployeeMenu;

public class EmployeeCont {
	private EmployeeService es = new EmployeeService();
	
	public EmployeeCont() {
	}
	
	
	public HashMap<String,Employee> selectAll() {
		HashMap<String,Employee> hm = null; 
				try {
					hm = es.selectMap();
					
				} catch (EmployeeException e) {
					new EmployeeMenu().printError(e.getMessage());
					new EmployeeMenu().displayMenu();
		}
		return hm;
	}


	public Employee selectEmp(String empid) {
		Employee emp = null; 
				try {
					emp = es.selectOne2(empid);
					
				} catch (EmployeeException e) {
					new EmployeeMenu().printError(e.getMessage());
					new EmployeeMenu().displayMenu();
				}
		
		return emp;
	}


	public HashMap<String,Employee> selectJobid(String jobid) {
		HashMap<String,Employee> hm = null;
				try {
					hm = es.selectJobMap(jobid);
				} catch (EmployeeException e) {
					new EmployeeMenu().printError(e.getMessage());
					new EmployeeMenu().displayMenu();
				}
		
		return hm;
	}


	public HashMap<String,Employee> selectDeptid(String deptid) {
		HashMap<String, Employee> hm = null;
				try {
					hm = es.selectDeptMap(deptid);
				} catch (EmployeeException e) {
					new EmployeeMenu().printError(e.getMessage());
					new EmployeeMenu().displayMenu();
				}
		
		return hm;
	}


	public void insertEmp(Employee emp) {
			try {
				int result = es.insert2(emp);
				if(result > 0)
					System.out.println("직원 등록 성공");
			} catch (EmployeeException e) {
				new EmployeeMenu().printError(e.getMessage());
				new EmployeeMenu().displayMenu();
			}
	}


	public void updatePhone(Employee emp) {
		try {
			int result = es.updatePhone(emp);
			if(result > 0) 
				System.out.println("\n직원의 전화번호 변경 성공");
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}
		
		
	}


	public void updateBonusPct(Employee emp) {
		try {
			int result = es.updateBonusPct(emp);
			if(result > 0) 
				System.out.println("\n직원의 보너스포인트 변경 성공");
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}
		
	}


	public void deleteEmp(String empid) {
		try {
			int result = es.deleteEmp(empid);
			if(result > 0) 
				System.out.println("\n직원 삭제 성공");
		} catch (EmployeeException e) {
			new EmployeeMenu().printError(e.getMessage());
			new EmployeeMenu().displayMenu();
		}
	}
	
}
