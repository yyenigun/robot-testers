package com.iyzico.robots.infrastructure.rest;

import com.iyzico.robots.application.controller.CustomerController;
import com.iyzico.robots.application.converter.CustomerDtoConverter;
import com.iyzico.robots.application.model.CustomerDto;
import com.iyzico.robots.domain.entity.Customer;
import com.iyzico.robots.domain.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCustomerController implements CustomerController {

    private CustomerService customerService;
    private CustomerDtoConverter customerDtoConverter;

    public RestCustomerController(CustomerService customerService,
                                  CustomerDtoConverter customerDtoConverter) {
        this.customerService = customerService;
        this.customerDtoConverter = customerDtoConverter;
    }

    @GetMapping("/api/v1/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public CustomerDto getCustomer(@PathVariable Long id) {
        Customer customer = customerService.retrieveCustomer(id);
        return customerDtoConverter.convert(customer);
    }
}
