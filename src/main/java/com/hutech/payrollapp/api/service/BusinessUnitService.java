package com.hutech.payrollapp.api.service;

import java.util.List;

import com.hutech.payrollapp.api.model.BusinessUnit;

public interface BusinessUnitService {

	String save(BusinessUnit businessUnit);

	List<BusinessUnit> findAll();
	
}
