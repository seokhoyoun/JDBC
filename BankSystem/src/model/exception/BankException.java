package model.exception;

public class BankException extends Exception{

	private static final long serialVersionUID = 1808763821710446725L;

	public BankException() {
	}
	
	public BankException(String mes) {
		super(mes);
	}
}
