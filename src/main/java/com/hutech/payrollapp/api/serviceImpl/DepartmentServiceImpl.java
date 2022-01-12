package com.hutech.payrollapp.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.exceptionhandler.IdAlreadyExistException;
import com.hutech.payrollapp.api.exceptionhandler.NameAlreadyExistException;
import com.hutech.payrollapp.api.model.Department;
import com.hutech.payrollapp.api.repository.DepartmentRepository;
import com.hutech.payrollapp.api.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;

	public boolean checkIfUserIdExist(int departmentId) {
		return departmentRepo.findByDepartmentId(departmentId) != null ? true : false;
	}

	public boolean checkIfDepartmentNameExist(String departmentName) {
		return departmentRepo.findByDepartmentName(departmentName) != null ? true : false;
	}

	@Override
	public String save(Department department) throws IdAlreadyExistException, NameAlreadyExistException {
		if (checkIfUserIdExist(department.getDepartmentId())) {
			throw new IdAlreadyExistException("Department Id already Exist!. Please check the Id.", 409);
		}
		if (checkIfDepartmentNameExist(department.getDepartmentName())) {
			throw new NameAlreadyExistException("Department Name already Exist!. Please check the Name.", 409);
		}
		departmentRepo.save(department);
		return "Department Added";
	}

	@Override
	public List<Department> get() {
		List<Department> department = (List<Department>) departmentRepo.findAll();
		return department;

	}

}
