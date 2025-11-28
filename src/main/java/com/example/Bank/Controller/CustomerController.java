package com.example.Bank.Controller;

import com.example.Bank.Entity.CustomerEntity;
import com.example.Bank.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public CustomerEntity create(@RequestBody CustomerEntity customer){
        return customerService.createcustomer(customer);
    }




}
