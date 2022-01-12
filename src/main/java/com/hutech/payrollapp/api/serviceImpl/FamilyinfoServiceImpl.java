package com.hutech.payrollapp.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Family;
import com.hutech.payrollapp.api.repository.FamilyinfoRepository;
import com.hutech.payrollapp.api.service.FamilyinfoService;

@Service
public class FamilyinfoServiceImpl implements FamilyinfoService {
	
	@Autowired
	private FamilyinfoRepository familyinfoRepository;

	@Override
	public String save(Family familyinfo) {
		familyinfoRepository.save(familyinfo);
		return "Family Info Added...";
	}

	@Override
	public Optional<Family> findById(Long familyId) {
		return familyinfoRepository.findById(familyId);
	}

	@Override
	public String deleteById(Long familyId) {
		familyinfoRepository.deleteById(familyId);
		return "Information Deleted...";
	}

}
