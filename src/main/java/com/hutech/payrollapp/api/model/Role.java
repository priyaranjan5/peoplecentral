package com.hutech.payrollapp.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Role {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;

	@Id
	@NotEmpty
	private String roleName;
	
	@OneToMany(mappedBy = "roles")
	@JsonIgnore
	private List<Employee> employee = new ArrayList<Employee>();
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Role(int roleId, @NotEmpty String roleName, List<Employee> employee) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.employee = employee;
	}

	public Role() {
		super();
	}
}
