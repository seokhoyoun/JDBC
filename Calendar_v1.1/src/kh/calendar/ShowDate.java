package kh.calendar;

import java.util.Calendar;

public class ShowDate {
	
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		DateCalculator totalDay = new DateCalculator();
		System.out.println(totalDay.isLeapYear(totalDay.getYear()) == true? "윤년":"평년");
		long total = totalDay.getDays();
		System.out.println("총 날짜수 : "+ total);
	}

}
