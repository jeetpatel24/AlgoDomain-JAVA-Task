package com.domain.algo.repository;

import com.domain.algo.entity.Customer;
import com.domain.algo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUser_Id(Long id);
}
