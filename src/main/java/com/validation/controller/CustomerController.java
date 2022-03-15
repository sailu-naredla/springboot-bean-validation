package com.validation.controller;

import com.validation.dto.Customer;
import com.validation.group.UpdateInfo;
import com.validation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@Valid @RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") @NotNull Long id){
        return customerService.getCustomer(id);
    }

    @Validated(UpdateInfo.class)
    @PutMapping("/")
    public Customer updateCustomer(@Valid @RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

}
