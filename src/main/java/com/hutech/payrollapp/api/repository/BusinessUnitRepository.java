package com.hutech.payrollapp.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.BusinessUnit;

@Repository
public interface BusinessUnitRepository extends CrudRepository<BusinessUnit, Integer> {

}
