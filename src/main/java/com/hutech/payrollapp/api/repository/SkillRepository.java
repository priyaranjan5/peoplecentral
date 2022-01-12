package com.hutech.payrollapp.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer>{

}
