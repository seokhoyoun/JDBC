package sche.model.vo;

import java.io.Serializable;

public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9094521820763193567L;
	private String title;
	private String text;
	private String time;
	
	public Schedule() {
	}

	public Schedule(String title, String text, String time) {
		super();
		this.title = title;
		this.text = text;
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return title + "," + text + "," + time;
	}
	
	
	
}
