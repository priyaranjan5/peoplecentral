package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Skill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int skill_id;
	
	@NotEmpty
	private String skill_name;
	
	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkill_name() {
		return skill_name;
	}

	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}

	public Skill() {
	}

	public Skill(int skill_id, String skill_name) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
	}

}
