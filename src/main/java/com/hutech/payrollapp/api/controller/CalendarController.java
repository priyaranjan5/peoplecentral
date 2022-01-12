package com.hutech.payrollapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.exceptionhandler.ResourceNotFoundException;
import com.hutech.payrollapp.api.model.Calendar;
import com.hutech.payrollapp.api.model.Holiday;
import com.hutech.payrollapp.api.service.CalendarService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CalendarController {

	@Autowired
	private CalendarService calendarService;

	@PostMapping("/addCalendarRegion")
	public String addCalendarRegion(@RequestBody Calendar calender) {
		calendarService.addCalendarRegion(calender);
		return "New Calender has Created...";
	}

	@PostMapping("/addHoliday")
	public String addHoliday(@RequestBody Holiday holidayList) {
		calendarService.addHolidayList(holidayList);
		return "Holiday has Added Sucessfully to Calendar";
	}

	@GetMapping("/findHolidayList")
	public List<Holiday> getAllHolidayList() {
		return calendarService.getAllHolidayList();
	}
	
	@GetMapping("/findHolidayByRegion/{calendarRegion}")
	public List<Holiday> findHolidayByRegion(@PathVariable String calendarRegion){
		return calendarService.findById(calendarRegion);
	}

	@PutMapping("/holidayList/{hId}")
	public String updateHolidayList(@RequestBody Holiday holidayList, @PathVariable(value = "hId") Long hId) {
		calendarService.updateHolidayList(holidayList, hId);
		return "Holiday has updated SucessFully...";
	}

	@DeleteMapping("/{hId}")
	public ResponseEntity<String> deleteHoliday(@PathVariable(value = "hId") Long hId)
			throws ResourceNotFoundException {
		return calendarService.deleteHolidayList(hId);

	}
}
