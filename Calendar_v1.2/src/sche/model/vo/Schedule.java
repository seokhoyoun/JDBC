package sche.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Schedule implements Serializable {

	private static final long serialVersionUID = 9094521820763193567L;
	private String id;
	private String title;
	private Date time;
	private String content;
	
	public Schedule() {
	}

	
	public Schedule(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}


	public Schedule(String id, String title, Date time, String content) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return id + "\t" + title + "\t" + time + "\t" + content;
	}
	
	

	

	
	
	
	
}
