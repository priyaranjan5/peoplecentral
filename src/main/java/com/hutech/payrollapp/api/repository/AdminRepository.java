package com.hutech.payrollapp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.AdminLogin;

@Repository
public interface AdminRepository extends JpaRepository<AdminLogin, Long> {

	List<AdminLogin> findByResetPassword(String token);
	
	AdminLogin findByEmpEmail(String empEmail);
	AdminLogin findByAdminToken(String adminToken);

}
