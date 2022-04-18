package com.domain.algo.service;

import com.domain.algo.entity.Seller;
import com.domain.algo.entity.Users;
import com.domain.algo.repository.SellerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SellerServiceImplTest {

    @Mock
    SellerRepository sellerRepository;
    @InjectMocks
    SellerServiceImpl sellerService;

    @Test
    void addUser() {
    }

    @Test
    void getAllSellers() {
        List<Seller> expectedSeller = new ArrayList<>();
        expectedSeller.add(new Seller(new Users("user1", "user1@gmail.com")));
        expectedSeller.add(new Seller(new Users("user2", "user2@gmail.com")));
        expectedSeller.add(new Seller(new Users("user3", "user3@gmail.com")));

        when(sellerRepository.findAll()).thenReturn(expectedSeller);
        List<Seller> actualSeller = sellerService.getAllSellers();

        assertEquals(expectedSeller, actualSeller);
    }
}