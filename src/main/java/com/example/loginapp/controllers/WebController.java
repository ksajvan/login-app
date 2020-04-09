package com.example.loginapp.controllers;

import com.example.loginapp.entity.Customer;
import com.example.loginapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> response = customerService.getCustomers();
        if (response.size() > 0) {
            return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @GetMapping(path = "/operators")
    public ResponseEntity<String> getTestData() {
        return new ResponseEntity<>("Operators Test Data", HttpStatus.OK);
    }
}
