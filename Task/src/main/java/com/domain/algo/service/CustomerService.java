package com.domain.algo.service;

import com.domain.algo.dto.CustomerDTO;
import com.domain.algo.entity.Customer;
import com.domain.algo.entity.Seller;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(CustomerDTO customerDTO) throws Exception;

    List<Customer> getCustomers();
}
