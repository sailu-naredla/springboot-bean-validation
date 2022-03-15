package com.validation.service;


import com.validation.dto.Customer;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer getCustomer(Long id);

    public Customer updateCustomer(Customer customer);

}
