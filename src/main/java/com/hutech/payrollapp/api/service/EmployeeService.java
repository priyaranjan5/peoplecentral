package com.hutech.payrollapp.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;

import com.hutech.payrollapp.api.exceptionhandler.ApiException;
import com.hutech.payrollapp.api.exceptionhandler.EmailAlreadyExistException;
import com.hutech.payrollapp.api.model.Employee;

public interface EmployeeService {

	String save(Employee employee) throws MessagingException, EmailAlreadyExistException;

	String addFile(MultipartFile image, MultipartFile resume,String empId) throws IOException,ApiException;

	Optional<Employee> findById(String empId);

	List<Employee> findAll();

	String findE(Employee loginRequest);

}

/*
 * String save(MultipartFile image, MultipartFile resume, Employee employee)
 * throws IOException, IdAlreadyExistException, EmailAlreadyExistException,
 * MessagingException;
 */
