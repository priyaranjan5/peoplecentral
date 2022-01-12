package com.hutech.payrollapp.api.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Timesheet;
import com.hutech.payrollapp.api.repository.TimesheetRepository;
import com.hutech.payrollapp.api.service.TimesheetService;

import net.bytebuddy.utility.RandomString;

@Service
public class TimesheetServiceImpl implements TimesheetService {
	
	@Autowired
	private TimesheetRepository timesheetRepo;

	@Override
	public String save(Timesheet timeSheet) {
		String randomCode = RandomString.make(64);
		timeSheet.setVerificationCode(randomCode);
		timeSheet.setEnabled(false);
		timesheetRepo.save(timeSheet);
		return "Timesheet Added";
	}

}
