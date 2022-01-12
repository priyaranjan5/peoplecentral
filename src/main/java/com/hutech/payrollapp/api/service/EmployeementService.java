package com.hutech.payrollapp.api.service;

import java.util.List;

import com.hutech.payrollapp.api.model.Employeement;

public interface EmployeementService {

	Employeement save(Employeement employeement);

	List<Employeement> get();

}
