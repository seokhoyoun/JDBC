package test.calendar;

import java.util.Calendar;

public class DateCalculator {
	Calendar today = Calendar.getInstance();
	private int year = today.get(Calendar.YEAR);
	private int month = today.get(Calendar.MONTH) + 1;
	private int date = today.get(Calendar.DATE);
	private int ampm = today.get(Calendar.AM_PM);
	private int hour = today.get(Calendar.HOUR);
	private int min = today.get(Calendar.MINUTE);
	private int sec = today.get(Calendar.SECOND);
	
	public DateCalculator() {
		
	}
	public DateCalculator(Calendar today, int year, int month, int date, int ampm, int hour, int min, int sec) {
		this.today = today;
		this.year = year;
		this.month = month;
		this.date = date;
		this.ampm = ampm;
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	public Calendar getToday() {
		return today;
	}
	public void setToday(Calendar today) {
		this.today = today;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getAmpm() {
		return ampm;
	}
	public void setAmpm(int ampm) {
		this.ampm = ampm;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public long getDays() {
		long sumDays = 0L;
		for(int i = 1; i < this.year; i++) {
			if(isLeapYear(i))
				sumDays += 366;
			else
				sumDays += 365;
		}
		for(int i = 1; i < this.month; i++) {
			if(i == 4 || i == 6 || i == 9 || i == 11)
				sumDays += 30;
			else if(i == 2)
				sumDays += 28;
			else
				sumDays += 31;
		}
		if(isLeapYear(this.year))
			sumDays += 1;
		
		
		
		return sumDays;
	}
	
	public boolean isLeapYear(int years) {
		if(years%4 == 0 &&(years%100 != 0 || years%400 == 0)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
