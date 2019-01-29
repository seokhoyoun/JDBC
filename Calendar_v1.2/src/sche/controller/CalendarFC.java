package sche.controller;

import java.util.Calendar;

public class CalendarFC implements ICalendar{

	private Calendar now = Calendar.getInstance();
	
	public Calendar getCalendar() {
		return now;
	}
	
	@Override
	public String[][] printCalendar() {
		now.set(Calendar.DATE, 1);
		String[][] drr = new String[6][7];
		int lastday = now.getActualMaximum(Calendar.DATE);
		int count = 1;
		int dd = 1;
		for(int i = 0; i < drr.length; i++) {
			for(int j = 0; j < drr[i].length; j++) {
				if(count++ < now.get(Calendar.DAY_OF_WEEK)) 
					drr[i][j] = " ";
				else if(dd > lastday) 
					drr[i][j] = " ";
				else 
					drr[i][j] = String.valueOf(dd++);
			}
		}
		return drr;
		
	}
	
	@Override
	public String[][] switchCalendar(int year, int month) {
		now.set(Calendar.YEAR, year);
		now.set(Calendar.MONTH, month-1);
		return printCalendar();
		
	}
	
	

}
