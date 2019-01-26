package test.calendar;

import java.util.Scanner;

public class ShowDate {
	public static void main(String[] args) {
		DateCalculator totalDay = new DateCalculator();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("올해는?  ");
		System.out.println((totalDay.isLeapYear(totalDay.getYear()) == true) ? "윤년" : "평년");
		//1년 1월 1일부터 오늘까지의 총 날수 계산 출력
		long total = totalDay.getDays();
		System.out.println("총 날짜 수 : "+ total+ "일");
	}
}
