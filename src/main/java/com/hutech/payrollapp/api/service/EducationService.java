package com.hutech.payrollapp.api.service;

import java.util.Optional;

import com.hutech.payrollapp.api.model.Education;

public interface EducationService {

	String save(Education education);

	Optional<Education> findById(Long courseId);

	String deleteById(Long courseId);

}
