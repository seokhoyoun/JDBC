package sche.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import sche.controller.CalendarFC;
import sche.controller.ScheduleFC;
import sche.model.vo.Schedule;

public class ScheMenu {
	
	private ScheduleFC s = new ScheduleFC();
	private CalendarFC c = new CalendarFC();
	private Scanner sc = new Scanner(System.in);
	static int count = 0; 
	
	public void mainMenu() {
		c.printCalendar();
		
		while(true) {
			System.out.println("====================================================");
			System.out.println("1. 일정 추가\n"
				+ "2. 일정 수정\n"
				+ "3. 일정 삭제\n"
				+ "4. 전체 일정 조회\n"
				+ "5. 출력 월 변경\n"
				+ "6. 파일 저장하기\n"
				+ "7. 파일 불러오기\n"
				+ "0. 종료\n");
		System.out.print("번호 입력 : ");
		int mnum = sc.nextInt();
		
		switch(mnum) {
		case 1 : s.addSchedule(chooseDate(), putData()); break;
		case 2 : s.modifySchedule(chooseSche(),putData());break;
		case 3 : s.delSchedule(chooseSche());break;
		case 4 : printSchedule(s.printSchedule()); break;
		case 5 : c.switchCalendar(); break;
		case 6 : s.fileSave(); break;
		case 7 : s.fileLoad(); break;
		case 0 : return;
		}
		
		}
	}
	public Schedule putData() {
		System.out.println("일정 제목 입력 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("일정 내용을 입력해주세요 (종료:exit)");
		StringBuilder sb = new StringBuilder();
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")) {
			sb.append(line+"\n");
		}
		return new Schedule(title, sb.toString());
	}
	
	// 날짜 출력 메소드
	public void printCalendar() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'년 'MMM");
		System.out.println(sdf.format(c.getCalendar().getTime()));
		String[][] drr = c.printCalendar();
		System.out.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
		for(int i = 0; i < drr.length; i++) {
			for(int j = 0; j < drr[i].length; j++) {
				System.out.print(drr[i][j]+"\t");
			}System.out.println();
		}
	}
	// 일정 전체 출력 메소드
	public void printSchedule(ArrayList<Schedule> list) {
		if(!list.isEmpty()) {
		for(Schedule e : list)
			System.out.println(e);
		}
	}
	// 선택 일정 출력 메소드
	public void printSchedule(String index) {
		
	}
	// 일정을 추가하기위해 해당 날짜를 정하는 메소드
	public String chooseDate() {
		Calendar now = c.getCalendar();
		String month = String.valueOf(now.get(Calendar.MONTH)+1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		System.out.print(month+"월 1일 부터 ~ "+now.getActualMaximum(Calendar.DATE)+"일 사이의 날짜를 입력하세요 : ");
		int date = sc.nextInt();
		now.set(Calendar.DATE, date);
		return sdf.format(now.getTime()); 
	}
	
	public String chooseSche() {
		System.out.print("변경하실 일정 번호를 입력하세요 : ");
		return String.valueOf(sc.nextInt());
	}

}
