package com.telefonica.mockapi.model;

import java.io.Serializable;

public class ValidFor implements Serializable{
	private static final long serialVersionUID = 1L;

	private String 	startDateTime;
	private String 	endDateTime;

	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
}
