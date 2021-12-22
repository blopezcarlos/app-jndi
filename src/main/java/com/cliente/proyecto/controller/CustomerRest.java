package com.cliente.proyecto.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.proyecto.dto.CustomerDTO;
import com.cliente.proyecto.service.imp.CustomerServiceImpl;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerRest {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@RequestMapping(value = "all")
    public ResponseEntity<List<CustomerDTO>> getList() {
		final HttpHeaders httpHeaders= new HttpHeaders();
		try {
	        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	        List<CustomerDTO> list = customerService.getAll();
	        return new ResponseEntity<List<CustomerDTO>>(list, httpHeaders, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<CustomerDTO>>(new ArrayList<>(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
