package com.hutech.payrollapp.api.service;

import java.util.Optional;

import com.hutech.payrollapp.api.model.Family;

public interface FamilyinfoService {

	String save(Family familyinfo);

	Optional<Family> findById(Long familyId);

	String deleteById(Long familyId);

}
