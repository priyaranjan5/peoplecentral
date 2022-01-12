package com.hutech.payrollapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Login;



@Repository
public interface Loginrepository extends JpaRepository<Login, Long> {

	Login findByusername(String username);
	
	
}
