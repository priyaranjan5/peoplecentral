package com.hutech.payrollapp.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.exceptionhandler.IdAlreadyExistException;
import com.hutech.payrollapp.api.exceptionhandler.NameAlreadyExistException;
import com.hutech.payrollapp.api.model.Designation;
import com.hutech.payrollapp.api.repository.DesignationRepository;
import com.hutech.payrollapp.api.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepository designationRepo;

	public boolean checkIfDesignationIdExist(int designationId) {
		return designationRepo.findByDesignationId(designationId) != null ? true : false;
	}

	public boolean checkIfDesignationNameExist(String designationName) {
		return designationRepo.findByDesignationName(designationName) != null ? true : false;
	}

	@Override
	public String save(Designation designation) throws IdAlreadyExistException, NameAlreadyExistException {
		if (checkIfDesignationIdExist(designation.getDesignationId())) {
			throw new IdAlreadyExistException("Designation Id already Exist!. Please check the Id.", 409);
		}
		if (checkIfDesignationNameExist(designation.getDesignationName())) {
			throw new NameAlreadyExistException("Designation Name already Exist!. Please check the Name.", 409);
		}
		designationRepo.save(designation);
		return "Designation Saved";
	}

	@Override
	public List<Designation> get() {
		List<Designation> designation = (List<Designation>) designationRepo.findAll();
		return designation;
	}

}
