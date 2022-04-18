package com.domain.algo.service;

import com.domain.algo.dto.UserDTO;
import com.domain.algo.entity.Users;
import com.domain.algo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {


    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addUser() {
        //given
        Users user = new Users("user1", "user1@gmail.com");
        //when
        userRepository.save(user);
        //then
        ArgumentCaptor<Users> argumentCaptor =
                ArgumentCaptor.forClass(Users.class);

        //verify that save method is called on userRepository and also capture the passed argument
        Mockito.verify(userRepository)
                .save(argumentCaptor.capture());

        Users capturedUser = argumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        //given
        Users user = new Users("user1", "user1@gmail.com");

        given(userRepository.findByEmail(user.getEmail()))
                .willReturn(user);

        //when
        //then
        UserDTO userDTO = new UserDTO(user.getUsername(), user.getEmail());
        assertThatThrownBy(()->userService.addUser(userDTO))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("Email already exist");

        verify(userRepository, never()).save(any());
    }

    @Test
    @Disabled
    void getAllUsers() {
    }
}