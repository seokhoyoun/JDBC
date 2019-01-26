package seokho.youn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TestCalendar {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'년' MM'월' dd'일'");
		
		Calendar now = Calendar.getInstance();
		System.out.println("오늘은 "+sdf.format(now.getTime())+" 입니다");
		System.out.print("year : ");
		String year = sc.next();
		System.out.print("month : ");
		String month = sc.next();
		

		now.set(now.YEAR, Integer.parseInt(year));
		now.set(now.MONTH, Integer.parseInt(month)-1);
		
		now.set(Calendar.DATE, 1);
		int lastday = now.getActualMaximum(Calendar.DATE); 
		System.out.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
		
		int dd = 1;
		int count = 1;
		String[][] drr = new String[6][7];
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
		
		for(int i = 0; i <drr.length; i++) {
			for(int j = 0; j < drr[i].length; j++) {
				System.out.print(drr[i][j]+"\t");
			}System.out.println();
		}
	}
}