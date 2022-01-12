package com.hutech.payrollapp.api.service;

import java.util.List;

import com.hutech.payrollapp.api.exceptionhandler.IdAlreadyExistException;
import com.hutech.payrollapp.api.exceptionhandler.NameAlreadyExistException;
import com.hutech.payrollapp.api.model.Designation;

public interface DesignationService {

	String save(Designation designation) throws IdAlreadyExistException,NameAlreadyExistException;

	List<Designation> get();

}
