package com.hutech.payrollapp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Payslip {
	
	@Id
	@Column(name = "Id")
	private String empId;
	private String employeeName;
	private String designation;
	private String empTYpe;
	private String duration;
	private String doj;
	private int noOfmonth;
	private int workingDay;

	private int bankAccountNo;
	private String ifscCode;
	private String bankName;
	private String branchName;
	private int panNo;

	private Double grossSal;
	private int grossearning;
	private Long gpMonthly;
	private Long basicsal;
	private Long hRA;
	private int specialAllowance;
	private int quarterlyVariable;
	private Long consultantSal;
	private int lop;
	private int totalArearDay;
	private int efectiveDay;
	private Boolean isMetrocity;
	

	private Long profeTax;
	private Long tds;
	private int tdsApplicableAmount;
	private Long pf;
	private Long esicNo;
	private Long totalDeduct;
	private int netPay;

	@OneToOne
	@JoinColumn(name = "empId")
	private Employee employee;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpTYpe() {
		return empTYpe;
	}

	public void setEmpTYpe(String empTYpe) {
		this.empTYpe = empTYpe;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public int getNoOfmonth() {
		return noOfmonth;
	}

	public void setNoOfmonth(int noOfmonth) {
		this.noOfmonth = noOfmonth;
	}

	public int getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(int workingDay) {
		this.workingDay = workingDay;
	}

	public int getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(int bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getPanNo() {
		return panNo;
	}

	public void setPanNo(int panNo) {
		this.panNo = panNo;
	}

	public Double getGrossSal() {
		return grossSal;
	}

	public void setGrossSal(Double grossSal) {
		this.grossSal = grossSal;
	}

	public int getGrossearning() {
		return grossearning;
	}

	public void setGrossearning(int grossearning) {
		this.grossearning = grossearning;
	}

	public Long getGpMonthly() {
		return gpMonthly;
	}

	public void setGpMonthly(Long gpMonthly) {
		this.gpMonthly = gpMonthly;
	}

	public Long getBasicsal() {
		return basicsal;
	}

	public void setBasicsal(Long basicsal) {
		this.basicsal = basicsal;
	}

	public Long gethRA() {
		return hRA;
	}

	public void sethRA(Long hRA) {
		this.hRA = hRA;
	}

	public int getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(int specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public int getQuarterlyVariable() {
		return quarterlyVariable;
	}

	public void setQuarterlyVariable(int quarterlyVariable) {
		this.quarterlyVariable = quarterlyVariable;
	}

	public Long getConsultantSal() {
		return consultantSal;
	}

	public void setConsultantSal(Long consultantSal) {
		this.consultantSal = consultantSal;
	}

	public int getLop() {
		return lop;
	}

	public void setLop(int lop) {
		this.lop = lop;
	}

	public int getTotalArearDay() {
		return totalArearDay;
	}

	public void setTotalArearDay(int totalArearDay) {
		this.totalArearDay = totalArearDay;
	}

	public int getEfectiveDay() {
		return efectiveDay;
	}

	public void setEfectiveDay(int efectiveDay) {
		this.efectiveDay = efectiveDay;
	}

	public Boolean getIsMetrocity() {
		return isMetrocity;
	}

	public void setIsMetrocity(Boolean isMetrocity) {
		this.isMetrocity = isMetrocity;
	}

	public Long getProfeTax() {
		return profeTax;
	}

	public void setProfeTax(Long profeTax) {
		this.profeTax = profeTax;
	}

	public Long getTds() {
		return tds;
	}

	public void setTds(Long tds) {
		this.tds = tds;
	}

	public int getTdsApplicableAmount() {
		return tdsApplicableAmount;
	}

	public void setTdsApplicableAmount(int tdsApplicableAmount) {
		this.tdsApplicableAmount = tdsApplicableAmount;
	}

	public Long getPf() {
		return pf;
	}

	public void setPf(Long pf) {
		this.pf = pf;
	}

	public Long getEsicNo() {
		return esicNo;
	}

	public void setEsicNo(Long esicNo) {
		this.esicNo = esicNo;
	}

	public Long getTotalDeduct() {
		return totalDeduct;
	}

	public void setTotalDeduct(Long totalDeduct) {
		this.totalDeduct = totalDeduct;
	}

	public int getNetPay() {
		return netPay;
	}

	public void setNetPay(int netPay) {
		this.netPay = netPay;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
