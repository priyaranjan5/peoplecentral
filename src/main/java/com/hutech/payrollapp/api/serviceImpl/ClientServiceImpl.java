package com.hutech.payrollapp.api.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Client;
import com.hutech.payrollapp.api.repository.ClientRepository;
import com.hutech.payrollapp.api.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepo;

	@Override
	public String save(Client client) {
		clientRepo.save(client);
		return "Client Added";
	}
	@Override
	public List<Client> findAll() {
		return (List<Client>) clientRepo.findAll();
	}

}

