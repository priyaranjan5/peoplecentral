package com.hutech.payrollapp.api.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.exceptionhandler.EmployeeNotFoundException;
import com.hutech.payrollapp.api.model.AdminLogin;
import com.hutech.payrollapp.api.model.Employee;
import com.hutech.payrollapp.api.repository.AdminRepository;

@Service
public class AdminLoginService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		AdminLogin adminLogin = adminRepository.findByEmpEmail(username);
		return new org.springframework.security.core.userdetails.User(adminLogin.getEmpEmail(), adminLogin.getPassword(),
				new ArrayList<>());
	}
}

