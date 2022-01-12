package com.hutech.payrollapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Payslip;
@Repository
public interface PayslipRepository extends JpaRepository<Payslip, Long> {

}
