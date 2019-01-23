package employee.controller;

import employee.model.dao.EmployeeDao;

public class EmployeeController {
	// 의존성 주입 : DI
	private EmployeeDao edao = new EmployeeDao();
	public EmployeeController() {
	}
}
