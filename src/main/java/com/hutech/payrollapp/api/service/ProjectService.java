package com.hutech.payrollapp.api.service;

import java.util.List;

import com.hutech.payrollapp.api.model.Project;

public interface ProjectService {

	String save(Project project);

	List<Project> viewProjectModule();

}
