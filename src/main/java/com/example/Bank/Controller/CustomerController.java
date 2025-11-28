package com.example.Bank.Controller;

import com.example.Bank.Entity.CustomerEntity;
import com.example.Bank.service.CustomerService;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public CustomerEntity create(@RequestBody CustomerEntity customer) throws BadRequestException {
        return customerService.createcustomer(customer);
    }

    @GetMapping("/customer/{customerid}")
    public CustomerEntity getCustomer(@PathVariable String customerid) {
        return customerService.getCustomerByCustomerId(customerid);
    }

}
