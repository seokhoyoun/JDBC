package model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Log implements Serializable{
	
	private static final long serialVersionUID = 3359548848484430476L;
	private String id; // 아이디
	private String receiverId; // 받는 사람 아이디 (* 이체 시)
	private String exDate; // 거래일시
	private int deposit; // 입금액
	private int withdraw; // 출금액
	private int type; // 1.입금 2.출금 3.송금
	private String comment;	// comment
	private String accNum; // 사용 계좌
	private String rccNum; // 받는 사람 계좌 (* 이체 시)
	
	public Log() {
	}

	// 입/출금용 생성자
	public Log(String id, int type, String comment, String accNum) {
		super();
		this.id = id;
		this.comment = comment;
		this.type = type;
		this.accNum = accNum;
	}
	// 송금용 생성자
	
	public Log(String id, String receiverId, int withdraw, int type, String comment, String accNum, String rccNum) {
		super();
		this.id = id;
		this.receiverId = receiverId;
		this.withdraw = withdraw;
		this.type = type;
		this.comment = comment;
		this.accNum = accNum;
		this.rccNum = rccNum;
	}

	
	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getRccNum() {
		return rccNum;
	}

	public void setRccNum(String rccNum) {
		this.rccNum = rccNum;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}


	public String getExDate() {
		return exDate;
	}


	public void setExDate(String exDate) {
		this.exDate = exDate;
	}


	public int getDeposit() {
		return deposit;
	}


	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}


	public int getWithdraw() {
		return withdraw;
	}


	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return id + "\t" + receiverId + "\t" + exDate + "\t" + deposit + "\t" + withdraw + "\t"+ comment;
	}

	
	
}
