package com.hutech.payrollapp.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Employeement;
import com.hutech.payrollapp.api.repository.EmployeementRepository;
import com.hutech.payrollapp.api.service.EmployeementService;

@Service
public class EmployeementServiceImpl implements EmployeementService {
	
	@Autowired
	private EmployeementRepository employeementRepo;

	@Override
	public Employeement save(Employeement employeement) {
		return employeementRepo.save(employeement);
	}

	@Override
	public List<Employeement> get() {
		List<Employeement> employeement = (List<Employeement>) employeementRepo.findAll();
		return employeement;
	}
	
}
