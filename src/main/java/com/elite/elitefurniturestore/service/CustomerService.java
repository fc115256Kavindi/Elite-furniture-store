package com.elite.elitefurniturestore.service;

import com.elite.elitefurniturestore.entity.Customer;
import com.elite.elitefurniturestore.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}