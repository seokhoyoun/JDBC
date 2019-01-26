package kh.calendar;

import java.util.Calendar;

public class DateCalculator {
	// Field
	Calendar today = Calendar.getInstance();
	int year = today.get(Calendar.YEAR);
	int month = today.get(Calendar.MONTH)+1;
	int day = today.get(Calendar.DAY_OF_MONTH);
	// Getter and Setter
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
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	//1년 1월 1일부터 오늘까지의 총 날수 계산 출력
	public long getDays() {
		long sumDays = 0L;
		// 올해 전까지 합산
		for(int i = 1; i < this.year; i++) {
			sumDays += 365;
			if(isLeapYear(i)) {
				sumDays += 1;
			}
		}
		// 이번달 전 까지 합산
		for(int i = 1; i < this.month; i++) {
			if(i == 4 || i == 6 || i == 9 || i == 11)
				sumDays += 30;
			else if(i == 2) {
				if(isLeapYear(this.year))
					sumDays += 29;
				else
					sumDays += 28;
			}
			else 
				sumDays += 31;
			
		}
		// 이번달 합산
		sumDays += this.day;
		return sumDays; // 결과 반환
	}
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && year%100 != 0 || year%400 == 0) 
			return true;
		else
			return false;
	}
}
