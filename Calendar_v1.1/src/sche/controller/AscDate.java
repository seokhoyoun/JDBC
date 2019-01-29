package sche.controller;

import java.util.Comparator;

import sche.model.vo.Schedule;

public class AscDate implements Comparator<Schedule> {

	@Override
	public int compare(Schedule s1, Schedule s2) {
		return s1.getId().compareTo(s2.getId());
	}


}
