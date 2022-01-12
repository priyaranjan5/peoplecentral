package com.hutech.payrollapp.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.exceptionhandler.Exceptionn;
import com.hutech.payrollapp.api.model.Calendar;
import com.hutech.payrollapp.api.model.Holiday;
import com.hutech.payrollapp.api.repository.CalendarRepository;
import com.hutech.payrollapp.api.repository.HolidayRepository;
import com.hutech.payrollapp.api.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarRepository calendarRepo;

	@Autowired
	private HolidayRepository holidayRepo;

	@Override
	public void addCalendarRegion(Calendar calender) {
		calendarRepo.save(calender);
	}

	@Override
	public void addHolidayList(Holiday holidayList) {
		holidayRepo.save(holidayList);
	}

	@Override
	public List<Holiday> getAllHolidayList() {
		return holidayRepo.findAll();
	}

	@Override
	public List<Holiday> findById(String calendarRegion) {
		return holidayRepo.findByCalendarRegion(calendarRegion);
	}

	@Override
	public String updateHolidayList(Holiday holidayList, Long hId) {
		Holiday holList = holidayRepo.findById(hId).orElseThrow(() -> new Exceptionn("Holiday", "hId", hId));
		holList.setHolidayName(holidayList.getHolidayName());
		holList.setDate(holidayList.getDate());
		holidayRepo.save(holList);
		return "Holiday List Updated";
	}

	@Override
	public ResponseEntity<String> deleteHolidayList(Long hId) {
		try {
			holidayRepo.deleteById(hId);
			return ResponseEntity.ok("Holiday deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.ok("Holiday not found");
		}
	}
}
