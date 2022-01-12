package com.hutech.payrollapp.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Education;
import com.hutech.payrollapp.api.repository.EducationRepository;
import com.hutech.payrollapp.api.service.EducationService;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepo;

	@Override
	public String save(Education education) {
		educationRepo.save(education);
		return "Education Details Added";
	}

	@Override
	public Optional<Education> findById(Long courseId) {
		return educationRepo.findById(courseId);
	}

	@Override
	public String deleteById(Long courseId) {
		educationRepo.deleteById(courseId);
		return "Course Deleted";
	}

}
