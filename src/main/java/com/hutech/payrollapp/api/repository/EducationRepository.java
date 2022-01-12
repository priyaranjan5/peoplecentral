package com.hutech.payrollapp.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long>{

}
