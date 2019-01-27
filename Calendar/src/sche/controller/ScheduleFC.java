package sche.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
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
	
	
	
	@Override
	public void addSchedule(String index, Schedule schedule) {
		
		int result = ss.addSchedule(index, schedule);
		if(result > 0)
			System.out.println("일정을 성공적으로 저장하였습니다.");
		else
			System.out.println("일정 저장을 실패했습니다.");
		
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
		
	}

	@Override
	public void delSchedule(String index) {
//		printSchedule(index);
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
