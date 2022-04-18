package com.domain.algo.repository;

import com.domain.algo.entity.Customer;
import com.domain.algo.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUser_Id() {
        Users user = userRepository.save(new Users("user1", "user1@gmail.com"));

        Customer savedCustomer = customerRepository.save(new Customer(user));
        Customer foundCustomer = customerRepository.findByUser_Id(user.getId());

        assertEquals(savedCustomer.getId(), foundCustomer.getId());
    }
}