package com.hutech.payrollapp.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Designation;

@Repository
public interface DesignationRepository extends CrudRepository<Designation, Integer> {

	Designation findByDesignationId(int designationId);

	Designation findByDesignationName(String designationName);

}
