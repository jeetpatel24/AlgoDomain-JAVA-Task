package com.domain.algo.service;

import com.domain.algo.entity.Customer;
import com.domain.algo.entity.Product;
import com.domain.algo.entity.Users;
import com.domain.algo.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    @Disabled
    void addCustomer() {
    }

    @Test
    void getCustomers() {
        List<Customer> expectedCustomer = new ArrayList<>();
        expectedCustomer.add(new Customer(new Users("user1", "user1@gmailcom")));
        expectedCustomer.add(new Customer(new Users("user2", "user2@gmailcom")));
        expectedCustomer.add(new Customer(new Users("user3", "user3@gmailcom")));

        when(customerRepository.findAll()).thenReturn(expectedCustomer);
        List<Customer> actualCustomer = customerService.getCustomers();

        assertEquals(expectedCustomer, actualCustomer);
        verify(customerRepository, times(1)).findAll();
    }
}