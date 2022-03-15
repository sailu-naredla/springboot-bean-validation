package com.validation.service.impl;

import com.validation.dto.Customer;
import com.validation.entity.CustomerEntity;
import com.validation.exception.BadRequestException;
import com.validation.exception.NoSuchElementFoundException;
import com.validation.exception.ResourceNotFoundException;
import com.validation.repository.CustomerRepository;
import com.validation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setLocation(customer.getLocation());
        customerEntity.setPhone(customer.getPhone());
        customerRepository.save(customerEntity);

        customer.setId(customerEntity.getId());
        return customer;
    }

    @Override
    public Customer getCustomer(Long id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if(customerEntity.isPresent()){
            Customer customer = new Customer();
            customer.setId(customerEntity.get().getId());
            customer.setName(customerEntity.get().getName());
            customer.setEmail(customerEntity.get().getEmail());
            customer.setLocation(customerEntity.get().getLocation());
            customer.setPhone(customerEntity.get().getPhone());
            return customer;
        }else{
            throw new NoSuchElementFoundException("Customer Not Found With ID "+id);
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(null != customer && null != customer.getId()){
            if(null == customer.getLocation() || customer.getLocation().isBlank()){
                throw new BadRequestException("Customer location is missed");
            }
            Optional<CustomerEntity> customerEntity = customerRepository.findById(customer.getId());
            if(customerEntity.isPresent()){
                CustomerEntity newCustomerEntity = customerEntity.get();
                newCustomerEntity.setLocation(customer.getLocation());
                customerRepository.save(newCustomerEntity);
                return customer;
            }else{
                throw new ResourceNotFoundException("Customer Not Found");
            }
        }else{
            throw  new NoSuchElementFoundException("Customer id is missed");
        }
    }
}
