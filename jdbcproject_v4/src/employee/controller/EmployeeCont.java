package employee.controller;

import java.util.ArrayList;
import java.util.HashMap;

import employee.model.dao.EmployeeDao;
import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import employee.view.EmployeeMenu;

public class EmployeeCont {
	private EmployeeService es = new EmployeeService();
	
	public EmployeeCont() {
	}
	
	
	public HashMap<String,Employee> selectAll() {
		HashMap<String,Employee> hm = es.selectMap();
		if(hm.size() == 0) {
			System.out.println("\n직원 정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		return hm;
	}


	public Employee selectEmp(String empid) {
		Employee emp = es.selectOne2(empid);
		if(emp == null) {
			System.out.println(empid+"사번 직원이 존재하지 않습니다.");
			new EmployeeMenu().displayMenu(); // 메뉴로가기. 좋은 방법은 아님.
		}
		
		return emp;
	}


	public HashMap<String,Employee> selectJobid(String jobid) {
		HashMap<String,Employee> hm = es.selectJobMap(jobid);
		if(hm.size() == 0) {
			System.out.println("\n해당 직급의 직원 정보가 없습니다.");
			new EmployeeMenu().displayMenu();
		}
		return hm;
	}


	public HashMap<String,Employee> selectDeptid(String deptid) {
		HashMap<String, Employee> hm = es.selectDeptMap(deptid);
		if(hm.size() == 0) {
			System.out.println("\n해당 부서의 직원 정보가 없습니다.");
			new EmployeeMenu().displayMenu();
		}
		return hm;
	}


	public void insertEmp(Employee emp) {
		int result = es.insert2(emp);
		
		if(result <= 0) {
			System.out.println("\n새 직원 등록 실패");
			System.out.println("확인하고 다시 시도해주세요.");
		}
		else {
			System.out.println("직원 저장 완료");
		}
		return;
	}


	public void updatePhone(Employee emp) {
		int result = es.updatePhone(emp);
		if(result > 0) {
			System.out.println("\n직원의 전화번호 변경 성공");
		}
		else {
			System.out.println("\n전화번호 변경 실패 \n확인하고 다시 시도하세요.");
		}
	}


	public void updateBonusPct(Employee emp) {
		int result = es.updateBonusPct(emp);
		if(result > 0) 
			System.out.println("\n직원의 보너스포인트 변경 성공");
		else 
			System.out.println("\n보너스 포인트 변경 실패\n확인하고 다시 시도하세요.");
		
	}


	public void deleteEmp(String empid) {
		int result = es.deleteEmp(empid);
		if(result > 0) 
			System.out.println("\n직원 삭제 성공");
		else 
			System.out.println("\n직원 삭제 실패\n확인하고 다시 시도하세요.");
	}
	
}
