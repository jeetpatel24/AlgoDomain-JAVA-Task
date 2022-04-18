package com.domain.algo.service;

import com.domain.algo.dto.UserDTO;
import com.domain.algo.entity.Users;

import java.util.List;

public interface UserService {
    Users addUser(UserDTO userDTO) throws Exception;

    List<Users> getAllUsers();
}
