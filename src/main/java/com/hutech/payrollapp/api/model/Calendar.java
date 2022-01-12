package com.hutech.payrollapp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Calendar {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Id
	@NotEmpty
	private String calendarRegion;

	@NotEmpty	
	private String description;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCalendarRegion() {
		return calendarRegion;
	}

	public void setCalendarRegion(String calendarRegion) {
		this.calendarRegion = calendarRegion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar(Long id, @NotEmpty String calendarRegion, @NotEmpty String description) {
		super();
		this.id = id;
		this.calendarRegion = calendarRegion;
		this.description = description;
	}

	public Calendar() {
		super();
	}

}
