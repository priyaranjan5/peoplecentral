package com.hutech.payrollapp.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	Department findByDepartmentId(int departmentId);

	Department findByDepartmentName(String departmentName);

}
