package com.hutech.payrollapp.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hutech.payrollapp.api.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}