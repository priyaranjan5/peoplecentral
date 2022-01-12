package com.hutech.payrollapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.model.Client;
import com.hutech.payrollapp.api.service.ClientService;

@RestController
@CrossOrigin(origins = "*")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("/addClient")
	public String addClient(@RequestBody Client client) {
		clientService.save(client);
		return "Client On-boarded";
	}
	@GetMapping("/onboardedClient")
	public List<Client> findall() {
		return (List<Client>) clientService.findAll();
	}
}
