package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Project {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String clientName;

	@Id
	@NotEmpty
	@Size(min = 5, max = 25, message = "PROJECT NAME MUST BE BETWEEN 5 TO 25 CHARACTERS")
	private String projectName;

	@NotEmpty
	@Size(min = 5, max = 25, message = "TASK NAME MUST BE BETWEEN 5 TO 25 CHARACTERS")
	private String task;

	@NotEmpty
	@Size(min = 1, max = 100, message = "DESCRIPTION MUST BE BETWEEN 1 TO 100 CHARACTERS")
	private String description;

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public Project(String clientName, String projectName, String task, String description) {
		super();
		this.clientName = clientName;
		this.projectName = projectName;
		this.task = task;
		this.description = description;
	}

	public Project() {

	}
}
