package com.hutech.payrollapp.api.service;

import java.util.List;

import com.hutech.payrollapp.api.model.Role;

public interface RoleService {

	String save(Role role);

	List<Role> get();

}
