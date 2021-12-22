package com.cliente.proyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cliente.proyecto.model.CustomerDO;

public interface CustomerRepository extends CrudRepository<CustomerDO, Long> {
	
	List<CustomerDO> findByLastName(String lastName);
}
