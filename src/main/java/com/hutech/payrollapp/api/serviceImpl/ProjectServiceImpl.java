package com.hutech.payrollapp.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Project;
import com.hutech.payrollapp.api.repository.ProjectRepository;
import com.hutech.payrollapp.api.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public String save(Project project) {
		projectRepo.save(project);
		return "Project added";
	}

	@Override
	public List<Project> viewProjectModule() {
		return projectRepo.findAll();
	}

}
