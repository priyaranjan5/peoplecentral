package com.hutech.payrollapp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

	@Query("select u from Project u where u.projectName = ?1")
	public List<Timesheet> findByProjectName(String ProjectName);

	@Query("SELECT t FROM Timesheet t WHERE t.verificationCode = ?1")
	public Timesheet findByVerificationCode(String verificationCode);
}
