package com.hutech.payrollapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

}
