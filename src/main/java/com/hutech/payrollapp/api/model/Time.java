package com.hutech.payrollapp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	
	@Column(name = "dayName")
	private String dayName;

	
	@Column(name = "workonHour")
	private String workonHour;

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getWorkonHour() {
		return workonHour;
	}

	public void setWorkonHour(String workonHour) {
		this.workonHour = workonHour;
	}

	public Time(String dayName, String workonHour) {

		this.dayName = dayName;
		this.workonHour = workonHour;
	}

	public Time() {

	}
}
