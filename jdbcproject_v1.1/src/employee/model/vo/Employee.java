package employee.model.vo;

import java.sql.Date;

public class Employee implements java.io.Serializable{
	private static final long serialVersionUID = 7L;
	
	private String empid;
	private String empName;
	private String empNO;
	private String email;
	private String phone;
	private Date hireDate;
	private String jobid;
	private int salary;
	private double bonusPct;
	private String marriage;
	private String mgrid;
	private String deptid;
	
	public Employee() {
	}

	public Employee(String empid, String empName, String empNO, String email, String phone, Date hireDate, String jobid,
			int salary, double bonusPct, String marriage, String mgrid, String deptid) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empNO = empNO;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.jobid = jobid;
		this.salary = salary;
		this.bonusPct = bonusPct;
		this.marriage = marriage;
		this.mgrid = mgrid;
		this.deptid = deptid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNO() {
		return empNO;
	}

	public void setEmpNO(String empNO) {
		this.empNO = empNO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonusPct() {
		return bonusPct;
	}

	public void setBonusPct(double bonusPct) {
		this.bonusPct = bonusPct;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMgrid() {
		return mgrid;
	}

	public void setMgrid(String mgrid) {
		this.mgrid = mgrid;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return empid + "\t" + empName + "\t" + empNO  + "\t" + phone + "\t" + hireDate + "\t" + jobid
				+ "\t" + salary + "\t" + bonusPct + "\t" + marriage + "\t" + mgrid + "\t" + deptid + "\t" + email;
	}
	
	/*@Override
	public String toString() {
		return empid + "  " + empName + "  " + empNO + "  " + email + "  " + phone + "  " + hireDate + "  " + jobid
				+ "  " + salary + "  " + bonusPct + "  " + marriage + "  " + mgrid + "  " + deptid;
	}*/

	/*@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", empNO=" + empNO + ", email=" + email
				+ ", phone=" + phone + ", hireDate=" + hireDate + ", jobid=" + jobid + ", salary=" + salary
				+ ", bonusPct=" + bonusPct + ", marriage=" + marriage + ", mgrid=" + mgrid + ", deptid=" + deptid + "]";
	}*/
	
	
}
