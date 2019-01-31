package controller;

import exception.LogException;
import model.service.LogService;
import model.vo.Account;
import model.vo.Log;

public class LogControl {
	
	private LogService ls;
	
	public LogControl() {
		try {
			ls = new LogService();
		} catch (LogException e) {
			e.printStackTrace();
		}
	}

	public void depositLog(Account acc, int dMoney) {
		Log log = new Log(acc.getId(), 1, acc.getName());
		log.setDeposit(dMoney);
		try {
			int result = ls.depositLog(log);
		} catch (LogException e) {
			e.printStackTrace();
		}
	}

	public void withdrawLog(Account acc, int wMoney) {
		Log log = new Log(acc.getId(), 2, acc.getName());
		log.setWithdraw(wMoney);
		try {
			int result = ls.withdrawLog(log);
		} catch (LogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void transferLog(Account acc, Account rcc, int tMoney) {
		Log log = new Log(acc.getId(), rcc.getId(), tMoney, 3, acc.getName()+" to "+rcc.getName());
		try {
			int result = ls.transfer(log);
		} catch (LogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
