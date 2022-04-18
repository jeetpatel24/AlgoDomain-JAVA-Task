package com.domain.algo.controller;

import com.domain.algo.dto.CustomerDTO;
import com.domain.algo.entity.Customer;
import com.domain.algo.entity.Seller;
import com.domain.algo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            Customer customer = customerService.addCustomer(customerDTO);
            return ResponseEntity.ok().body(customer);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<Customer> list = customerService.getCustomers();
        return ResponseEntity.ok().body(list);
    }
}
