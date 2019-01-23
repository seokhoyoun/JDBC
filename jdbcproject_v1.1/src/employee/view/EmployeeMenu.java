package employee.view;

import java.sql.Date;
import java.util.ArrayList;
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
			case 1 : printList(ec.selectAll()); break;
			case 2 : printEmp(ec.selectEmp(inputEmpid())); break;
			case 3 : printList(ec.selectJobid(inputJobid())); break;
			case 4 : printList(ec.selectDeptid(inputDeptid())); break;
			case 5 : ec.insertEmp(inputEmp()); break;
			case 6 : break;
			case 7 : break;
			case 8 : break;
			case 9 : System.out.print("\n종료(y) 취소(n) : "); 
					 if(sc.next().toUpperCase().charAt(0) == 'Y')
						 return;
					 else
						 break;
			default: System.out.println("없는 번호 입니다. 다시 입력하세요");
			}
		}while(true);
		
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

	public void printList(ArrayList<Employee> empList) {
		System.out.println("\n현재 조회된 직원 수는 "+ empList.size() +"명 입니다.");
		for(Employee e : empList) {
			System.out.println(e);
		}
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
}
