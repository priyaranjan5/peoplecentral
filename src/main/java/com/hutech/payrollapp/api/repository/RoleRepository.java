package com.hutech.payrollapp.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
