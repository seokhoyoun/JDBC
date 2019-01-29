package model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8034530850881165493L;
	private String accNumber; // 계좌번호
	private String ssN; // 주민번호
	private int bal; // 잔액
	private String phone; // 핸드폰번호
	private String name; // 이름
	private Date estDate; // 개설일
	private String id; // 아이디
	private String password; // 비밀번호
	
	
	public Account() {
	}
	
	

	public Account(String ssN, String phone, String name, String id, String password) {
		super();
		this.ssN = ssN;
		this.phone = phone;
		this.name = name;
		this.id = id;
		this.password = password;
	}



	public Account(String accNumber, String ssN, String name, Date estDate, String id, String password, int bal, String phone) {
		super();
		this.accNumber = accNumber;
		this.ssN = ssN;
		this.name = name;
		this.estDate = estDate;
		this.id = id;
		this.password = password;
		this.bal = bal;
		this.phone = phone;
	}


	public String getAccNumber() {
		return accNumber;
	}


	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}


	public String getSsN() {
		return ssN;
	}


	public void setSsN(String ssN) {
		this.ssN = ssN;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getEstDate() {
		return estDate;
	}


	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public int getBal() {
		return bal;
	}


	public void setBal(int bal) {
		this.bal = bal;
	}

	

	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return accNumber + "\t" + ssN + "\t" + bal + "\t" + phone + "\t" + name + "\t" + estDate + "\t" + id + "\t"
				+ password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNumber == null) ? 0 : accNumber.hashCode());
		result = prime * result + ((estDate == null) ? 0 : estDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((ssN == null) ? 0 : ssN.hashCode());
		return result;
	}


	
	
	
	
}
