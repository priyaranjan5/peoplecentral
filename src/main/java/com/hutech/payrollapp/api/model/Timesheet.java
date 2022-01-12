package com.hutech.payrollapp.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Timesheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String clientName;

	private String date;

	@NotEmpty
	@Size(min = 1, max = 25, message = "task may not be empty")
	private String task;

	@NotEmpty
	@Size(min = 1, max = 100, message = "description may not be empty")
	private String description;

	private String verificationCode;

	private boolean enabled;

	@OneToOne
	@JoinColumn(name = "projectName")
	private Project project;

	@OneToOne
	@JoinColumn(name = "empId")
	private Employee employee;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "timeSheet_id")
	private List<Time> time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Time> getTime() {
		return time;
	}

	public void setTime(List<Time> time) {
		this.time = time;
	}

	public Timesheet(Long id, String clientName, String date, String task, String description, String verificationCode,
			boolean enabled, Project project, Employee employee, List<Time> time) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.date = date;
		this.task = task;
		this.description = description;
		this.verificationCode = verificationCode;
		this.enabled = enabled;
		this.project = project;
		this.employee = employee;
		this.time = time;
	}

	public Timesheet() {
		super();
	}
}
