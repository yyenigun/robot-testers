package com.iyzico.robots.domain.service;

import com.iyzico.robots.domain.entity.Customer;
import com.iyzico.robots.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer retrieveCustomer(Long id) {
        return customerRepository.findById(id).get();
    }
}
