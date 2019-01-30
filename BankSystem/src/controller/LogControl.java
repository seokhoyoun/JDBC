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
		Log log = new Log(acc.getId(), dMoney, 1, acc.getName());
		int result = ls.depositLog(log);
	}

}
