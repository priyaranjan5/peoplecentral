package com.hutech.payrollapp.api.service;

import java.util.List;

import com.hutech.payrollapp.api.exceptionhandler.IdAlreadyExistException;
import com.hutech.payrollapp.api.exceptionhandler.NameAlreadyExistException;
import com.hutech.payrollapp.api.model.Department;

public interface DepartmentService {

	public String save(Department department) throws IdAlreadyExistException,NameAlreadyExistException;

	public List<Department> get();

}
