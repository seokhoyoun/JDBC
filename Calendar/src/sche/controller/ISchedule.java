package sche.controller;

import sche.model.vo.Schedule;

public interface ISchedule {
	
	public void addSchedule(String index, Schedule sche);
	
	public void modifySchedule(String index, Schedule sche);
	
	public void delSchedule(String index);
	
	
	
}
