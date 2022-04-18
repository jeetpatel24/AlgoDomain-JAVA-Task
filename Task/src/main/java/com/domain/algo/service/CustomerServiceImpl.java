package com.domain.algo.service;

import com.domain.algo.dto.CustomerDTO;
import com.domain.algo.entity.Customer;
import com.domain.algo.entity.Seller;
import com.domain.algo.entity.Users;
import com.domain.algo.repository.CustomerRepository;
import com.domain.algo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) throws Exception {
        //if user with given id does not exist
        if(userRepository.existsById(customerDTO.getUserId()) == false) {
            throw new Exception("user with id "+customerDTO.getUserId()+" does not exist, provide a valid id");
        }

        //if a user is already a customer
        if( customerRepository.findByUser_Id(customerDTO.getUserId()) != null) {
            throw new Exception("user is already a customer");
        }

        Users user = userRepository.getById(customerDTO.getUserId());
        Customer customer = customerRepository.save(new Customer(user));
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
