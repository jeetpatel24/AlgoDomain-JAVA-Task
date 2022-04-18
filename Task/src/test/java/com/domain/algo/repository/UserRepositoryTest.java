package com.domain.algo.repository;

import com.domain.algo.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByEmail() {
        Users savedUser = userRepository.save(new Users("user1", "user1@gmail.com"));
        Users foundUser = userRepository.findByEmail("user1@gmail.com");

        assertEquals(savedUser.getId(), foundUser.getId()); //(expected,actual)
    }
}