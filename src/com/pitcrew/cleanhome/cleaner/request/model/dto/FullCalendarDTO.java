package com.pitcrew.cleanhome.cleaner.request.model.dto;

import java.sql.Date;

public class FullCalendarDTO {

	private String title;
	private String start;
	private String backgroundColor;
	
	public FullCalendarDTO() {}

	public FullCalendarDTO(String title, String start, String backgroundColor) {
		super();
		this.title = title;
		this.start = start;
		this.backgroundColor = backgroundColor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public String toString() {
		return "FullCalendarDTO [title=" + title + ", start=" + start + ", backgroundColor=" + backgroundColor + "]";
	}


	
}
