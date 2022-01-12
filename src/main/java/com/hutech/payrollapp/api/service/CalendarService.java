package com.hutech.payrollapp.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hutech.payrollapp.api.model.Calendar;
import com.hutech.payrollapp.api.model.Holiday;

public interface CalendarService {

	void addCalendarRegion(Calendar calender);

	void addHolidayList(Holiday holidayList);

	List<Holiday> getAllHolidayList();
	
	List<Holiday> findById(String calendarRegion);

	String updateHolidayList(Holiday holidayList, Long hId);

	ResponseEntity<String> deleteHolidayList(Long hId);

	

}
