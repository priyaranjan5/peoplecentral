package com.hutech.payrollapp.api.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Skill;
import com.hutech.payrollapp.api.repository.SkillRepository;
import com.hutech.payrollapp.api.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillRepository skillRepo;

	@Override
	public String save(Skill skill) {
		skillRepo.save(skill);
		return "Skill Created";
	}
}
