package sche.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;

import sche.model.service.ScheduleService;
import sche.model.vo.Schedule;

public class ScheduleFC implements ISchedule{
	
	private Scanner sc = new Scanner(System.in);
	private HashMap<String,Schedule> hm = new HashMap<>();
	private ArrayList<String> keys = new ArrayList<String>();
	private ScheduleService ss = new ScheduleService();  
	
	public Schedule putData() {
		System.out.println("일정 제목 입력 : ");
		String title = sc.nextLine();
		System.out.println("일정 시간 입력 : ");
		String time = sc.nextLine();
		System.out.println("일정 내용을 입력해주세요 (종료:exit)");
		StringBuilder sb = new StringBuilder();
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")) {
			sb.append(line+"\n");
		}
		return new Schedule(title,sb.toString(),time);
	}
	
	@Override
	public void addSchedule(String index) {
		
		Schedule sd = putData();
		int result = ss.addSchedule(index, sd);
		/*for(int i = 1; i < 100; i++) {
			if(!(hm.containsKey(index+String.format("%02d", i)))) {
				hm.put(index+String.format("%02d", i), sd);
				keys.add(index+String.format("%02d", i));
				break;
			}
		}*/
	}
	
	

	@Override
	public void modifySchedule(String index) {
//		printSchedule(index);
		System.out.println("변경 할 일정 번호 입력 : ");
		String mnum = sc.next();
		sc.nextLine();
		if(hm.containsKey(mnum)) {
			Schedule sd = putData();
			hm.put(mnum, sd);
		}
		else
			System.out.println("해당 번호는 없습니다.");
		
	}

	@Override
	public void delSchedule(String index) {
		printSchedule(index);
		System.out.println("삭제 할 일정 번호 입력 : ");
		String mnum = sc.next();
		sc.nextLine();
		if(hm.containsKey(mnum)) {
			hm.remove(mnum);
			keys.remove(mnum);
			System.out.println("삭제가 완료되었습니다.");
		}
		else
			System.out.println("해당 번호는 없습니다.");
	}

	public void printSchedule() {
		keys.sort(new AscDate());
		for(Iterator<String> it2 = keys.iterator(); it2.hasNext();) {
			String key = it2.next();
			System.out.println("Sche. NO : " + key);
			System.out.println("TO DO : "+hm.get(key).getTitle());
			System.out.println("TIME : "+hm.get(key).getTime());
			System.out.println("COMMENT : "+hm.get(key).getText()+"\n");
		}
		
	}
	
	public void printSchedule(String index) {
		keys.sort(new AscDate());
		for(Iterator<String> it2 = keys.iterator(); it2.hasNext();) {
			String key = it2.next();
			if(key.substring(0, 8).contains(index)) {
			System.out.println("Sche. NO : " + key);
			System.out.println("TO DO : "+hm.get(key).getTitle());
			System.out.println("TIME : "+hm.get(key).getTime());
			System.out.println("COMMENT : "+hm.get(key).getText()+"\n");
			}
		}
	}

	public void fileSave() {
		System.out.println("저장할 파일 이름 : ");
		String fTitle = sc.next();
		Properties p = new Properties();
		for(Iterator<Entry<String, Schedule>> it = hm.entrySet().iterator(); it.hasNext();) {
			Entry<String, Schedule> ent = it.next();
			p.setProperty(ent.getKey(), ent.getValue().toString());
		}
			try {
				p.storeToXML(new BufferedOutputStream(new FileOutputStream(fTitle)),"Saved");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(fTitle+".xml 파일 저장이 완료되었습니다.");
		
	}
	
	public void fileLoad() {
		System.out.println("불러올 파일 이름 : ");
		String fTitle = sc.next();
		Properties p = new Properties();
		try {
			p.loadFromXML(new BufferedInputStream(new FileInputStream(fTitle)));
		} catch (IOException e) {
			e.printStackTrace();
		}
			System.out.println(p);
		
		
		System.out.println("파일 불러오기 성공");
	}

}
