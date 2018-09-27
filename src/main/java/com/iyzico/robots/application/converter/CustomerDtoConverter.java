package com.iyzico.robots.application.converter;

import com.iyzico.robots.application.model.CustomerDto;
import com.iyzico.robots.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.toString());
        return customerDto;
    }
}
