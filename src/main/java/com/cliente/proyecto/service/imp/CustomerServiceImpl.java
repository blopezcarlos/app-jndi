package com.cliente.proyecto.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.proyecto.dto.CustomerDTO;
import com.cliente.proyecto.model.CustomerDO;
import com.cliente.proyecto.repository.CustomerRepository;
import com.cliente.proyecto.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
//	public static Logger logger = Logger.getLogger(CustomerService.class);
	
    @Autowired
    private CustomerRepository customerRepository;
    
    private PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
    
    @Override
    public List<CustomerDTO> getAll() {
    	List<CustomerDTO> list = new ArrayList<>();
    	customerRepository.findAll().forEach(item -> list.add(copy(item)));
    	return list;
    }
    
    private CustomerDTO copy(CustomerDO origin) {
    	CustomerDTO destiny = new CustomerDTO();
    	try {
    		propertyUtilsBean.copyProperties(destiny, origin);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return destiny;
    }
     
    public void test() {
        // Save a new customer
        CustomerDO newCustomer = new CustomerDO();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Smith");
         
        customerRepository.save(newCustomer);
         
        // Find a customer by ID
        Optional<CustomerDO> result = customerRepository.findById(1L);
        result.ifPresent(customer -> System.out.println(customer));
         
        // Find customers by last name
        List<CustomerDO> customers = customerRepository.findByLastName("Smith");
        customers.forEach(customer -> System.out.println(customer));
         
        // List all customers
        Iterable<CustomerDO> iterator = customerRepository.findAll();
        iterator.forEach(customer -> System.out.println(customer));
         
        // Count number of customer
        long count = customerRepository.count();
        System.out.println("Number of customers: " + count);
    }
}
