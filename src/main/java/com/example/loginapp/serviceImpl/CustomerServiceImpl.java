package com.example.loginapp.serviceImpl;

import com.example.loginapp.entity.Customer;
import com.example.loginapp.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> getCustomers() {
        return createCustomers();
    }

    List<Customer> createCustomers() {
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        customers.add(customer3);

        return customers;
    }
}
