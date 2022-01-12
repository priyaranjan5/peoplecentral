package com.hutech.payrollapp.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.BusinessUnit;
import com.hutech.payrollapp.api.repository.BusinessUnitRepository;
import com.hutech.payrollapp.api.service.BusinessUnitService;

@Service
public class BusinessUnitServiceImpl implements BusinessUnitService {
	
	@Autowired
	private BusinessUnitRepository buRepo;

	@Override
	public String save(BusinessUnit businessUnit) {
		buRepo.save(businessUnit);
		return "Business Unit Created";
	}

	@Override
	public List<BusinessUnit> findAll() {
		return (List<BusinessUnit>) buRepo.findAll();
	}
}
