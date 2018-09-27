package com.iyzico.robots.application.controller;

import com.iyzico.robots.IntegrationTest;
import com.iyzico.robots.application.model.CustomerDto;
import com.iyzico.robots.domain.entity.Customer;
import com.iyzico.robots.domain.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CustomerControllerIT extends IntegrationTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/api/v1/customers/");
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));
    }

    @Test
    public void should_retrieve_first_customer() throws Exception {
        //given first customer id
        Long customerId = 1L;

        //when customer get request is sent
        ResponseEntity<CustomerDto> response = template.getForEntity(base.toString() + customerId,
                CustomerDto.class);

        //then customer named Jack Bauer will be retrieved
        assertThat(response.getBody().getName(), equalTo("Jack Bauer"));
    }
}
