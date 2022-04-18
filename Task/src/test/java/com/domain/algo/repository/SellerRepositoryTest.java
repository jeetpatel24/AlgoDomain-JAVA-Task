package com.domain.algo.repository;

import com.domain.algo.entity.Seller;
import com.domain.algo.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SellerRepositoryTest {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUser_Id() {
        Users user = userRepository.save(new Users("user1", "user1@gmsil.com"));

        Seller savedSeller = sellerRepository.save(new Seller(user));
        Seller actualSeller = sellerRepository.findByUser_Id(user.getId());

        assertEquals(savedSeller.getId(), actualSeller.getId());
    }
}