package employee.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import employee.controller.EmployeeCont;
import employee.model.vo.Employee;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in); 
	private EmployeeCont ec = new EmployeeCont();
	
	public void displayMenu() {
		int no;
		
		do {
			System.out.println("---------------------------------------------------");
			System.out.println("\n ****************** 직원 정보 관리 프로그램 *********************");
			System.out.println();
			System.out.println("1. 전체 직원 조회");
			System.out.println("2. 사번으로 직원 한명 조회");
			System.out.println("3. 직급별로 조회");
			System.out.println("4. 부서별로 조회");
			System.out.println("5. 새 직원 등록");
			System.out.println("6. 직원 전화번호 수정");
			System.out.println("7. 직원 보너스포인트 수정");
			System.out.println("8. 사번으로 직원 삭제");
			System.out.println("9. 끝내기");
			System.out.print("번호 선택 : ");
			no = sc.nextInt();
			
			switch(no) {
			case 1 : printMap(ec.selectAll()); break;
			case 2 : printEmp(ec.selectEmp(inputEmpid())); break;
			case 3 : printMap(ec.selectJobid(inputJobid())); break;
			case 4 : printMap(ec.selectDeptid(inputDeptid())); break;
			case 5 : ec.insertEmp(inputEmp()); break;
			case 6 : ec.updatePhone(inputPhone()); break;
			case 7 : ec.updateBonusPct(inputBonusPct()); break;
			case 8 : ec.deleteEmp(this.inputEmpid()); break;
			case 9 : System.out.print("\n종료(y) 취소(n) : "); 
					 if(sc.next().toUpperCase().charAt(0) == 'Y')
						 return;
					 else
						 break;
			default: System.out.println("없는 번호 입니다. 다시 입력하세요");
			}
		}while(true);
		
	}
	// 수정할 보너스 포인트와 해당 사번 입력용
	public Employee inputBonusPct() {
		Employee emp = new Employee();
		System.out.print("\n변경할 직원의 사번 입력 : ");
		emp.setEmpid(sc.next());
		System.out.print("변경할 보너스 포인트 입력 : ");
		emp.setBonusPct(sc.nextDouble());
		return emp;
	}
	
	// 수정할 전화번호와 사번 입력용
	public Employee inputPhone() {
		System.out.print("\n변경할 직원의 사번 입력 : ");
		Employee emp = new Employee();
		emp.setEmpid(sc.next());
		System.out.print("변경할 전화번호 - 빼고 입력 : ");
		emp.setPhone(sc.next());
		return emp;
		
	}
	// 새로 등록할 직원 정보 입력용
	public Employee inputEmp() {
		Employee emp = new Employee();
		System.out.print("이름 : ");
		emp.setEmpName(sc.next());
		System.out.print("주민번호 : ");
		emp.setEmpNO(sc.next());
		System.out.print("이메일 : ");
		emp.setEmail(sc.next());
		System.out.print("전화번호 - 빼고 입력:" );
		emp.setPhone(sc.next());
		System.out.print("입사일 [yyyy-mm-dd] : ");
		emp.setHireDate(Date.valueOf(sc.next()));
		System.out.print("급여 : ");
		emp.setSalary(sc.nextInt());
		System.out.print("보너스 포인트 : ");
		emp.setBonusPct(sc.nextDouble());
		System.out.print("직급 코드 : ");
		emp.setJobid(sc.next().toUpperCase());
		System.out.print("결혼 여부 (Y/N): ");
		emp.setMarriage(sc.next().toUpperCase());
		System.out.print("관리자 사번 : ");
		emp.setMgrid(sc.next());
		System.out.print("부서 코드 : ");
		emp.setDeptid(sc.next());
		
		return emp;
	}
	public String inputDeptid() {
		System.out.print("\n부서코드 입력 : ");
		return sc.next();
	}
	// 직급코드 입력
	public String inputJobid() {
		System.out.print("\n직급코드 입력 : ");
		return sc.next().toUpperCase();
	}

	public void printMap(HashMap<String,Employee> hm) {
		System.out.println("\n현재 조회된 직원 수는 "+ hm.size() +"명 입니다.");
		/*for(Iterator<String> it = hm.keySet().iterator(); it.hasNext();) {
			String empid = it.next();
			System.out.println(hm.get(empid));
		}*/
		
		/*for(Iterator<Entry<String, Employee>> it2 = hm.entrySet().iterator(); it2.hasNext();) {
			Entry<String, Employee> ent = it2.next();
			System.out.println(ent.getValue());
		}*/
		
		/*Collection<Employee> values = hm.values();
		for(Employee e : values)
			System.out.println(e);*/
		
		/*for(Employee e : hm.values())
			System.out.println(e);*/
		
//		Collection<Employee> values = hm.values();
//		Employee[] ear = new Employee[hm.size()];
//		values.toArray(ear);
//		for(Employee e : ear)
//			System.out.println(e);
		
		Collection<Employee> values = hm.values();
		for(Employee e : values.toArray(new Employee[hm.size()]))
			System.out.println(e);
		
	}
	
	// 사번 입력받아 리턴
	public String inputEmpid() {
		System.out.print("\n사번 입력 : ");
		return sc.next();
	}
	// 직원 한 사람 정보 출력용
	public void printEmp(Employee emp) {
		System.out.println("\n조회한 직원의 정보는 다음과 같습니다.");
		System.out.println(emp);
	}
	// 에러메세지 출력용
	public void printError(String message) {
		System.out.println("프로그램 오류 발생");
		System.out.println("시스템 관리자에게 문의하세요");
		System.out.println(message);
		
	}
}
