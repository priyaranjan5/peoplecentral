package com.hutech.payrollapp.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Role;
import com.hutech.payrollapp.api.repository.RoleRepository;
import com.hutech.payrollapp.api.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public String save(Role role) {
		roleRepo.save(role);
		return "Role Created";
	}

	@Override
	public List<Role> get() {
		List<Role> role = (List<Role>) roleRepo.findAll();
		return role;
	}
	
}
