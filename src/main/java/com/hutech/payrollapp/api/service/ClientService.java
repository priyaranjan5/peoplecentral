package com.hutech.payrollapp.api.service;

import java.util.List;

import com.hutech.payrollapp.api.model.Client;

public interface ClientService {

	String save(Client client);
	List<Client> findAll();
}
