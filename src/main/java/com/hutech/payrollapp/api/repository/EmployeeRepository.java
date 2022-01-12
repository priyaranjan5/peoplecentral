package com.hutech.payrollapp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

	Employee findByEmpEmail(String empEmail);

	Employee findByEmpId(String empId);

	List<Employee> findByResetPassword(String token);
	
	@Query("SELECT t FROM Employee t WHERE t.verificationToken = ?1")
	Employee findByVerificationToken(String verificationToken);
	
	@Query("FROM Employee  WHERE empEmail = ?1 AND password = ?2")
	Employee findByEmailAndPwd(String empEmail, String password);





}
