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
		int result = ls.depositLog(log);
	}

	public void withdrawLog(Account acc, int wMoney) {
		Log log = new Log(acc.getId(), 2, acc.getName());
		log.setWithdraw(wMoney);
		int result = ls.withdrawLog(log);
	}

}
