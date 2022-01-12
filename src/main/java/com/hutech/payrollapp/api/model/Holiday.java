package com.hutech.payrollapp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String holidayName;

	@Column(name = "date")
	@NotNull
	private String date;

	@ManyToOne
	@JoinColumn(name = "calendarRegion")
	private Calendar calendar;

	public void setId(Long id) {
		this.id = id;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Holiday(Long id, @NotEmpty String holidayName, @NotNull String date, Calendar calendar) {
		super();
		this.id = id;
		this.holidayName = holidayName;
		this.date = date;
		this.calendar = calendar;
	}

	public Holiday() {
		super();
	}

}
