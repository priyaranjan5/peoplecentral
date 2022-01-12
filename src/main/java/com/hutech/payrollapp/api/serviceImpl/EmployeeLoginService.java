package com.hutech.payrollapp.api.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Employee;
import com.hutech.payrollapp.api.repository.EmployeeRepository;

@Service
public class EmployeeLoginService implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String empEmail) throws UsernameNotFoundException {
		Employee emp= employeeRepository.findByEmpEmail(empEmail);
		return new org.springframework.security.core.userdetails.User(emp.getEmpEmail(), emp.getPassword(),
				new ArrayList<>());
	}
	
}
