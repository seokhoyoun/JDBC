package model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Log implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3359548848484430476L;
	private String id; // 아이디
	private String receiverId; // 받는 사람 아이디 (* 이체 시)
	private Date exDate; // 거래일시
	private int deposit; // 입금액
	private int withdraw; // 출금액
	private String comment;	// comment
	
	public Log() {
	}


	public Log(String id, String receiverId, Date exDate, int deposit, int withdraw, String comment) {
		super();
		this.id = id;
		this.receiverId = receiverId;
		this.exDate = exDate;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.comment = comment;
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


	public Date getExDate() {
		return exDate;
	}


	public void setExDate(Date exDate) {
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
