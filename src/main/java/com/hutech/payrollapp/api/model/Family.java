package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "family_info")
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long familyId;
	private String name;
	private String relationship;
	private String dateOfBirth;
	
/*	@OneToOne
	@JoinColumn(name = "empId")
	private Employee employee;*/

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

/*	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/

	public Family(Long familyId, String name, String relationship, String dateOfBirth) {
		super();
		this.familyId = familyId;
		this.name = name;
		this.relationship = relationship;
		this.dateOfBirth = dateOfBirth;
	}

	public Family() {
		super();
	}

}
