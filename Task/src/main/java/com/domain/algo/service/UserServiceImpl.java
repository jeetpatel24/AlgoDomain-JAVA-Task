package com.domain.algo.service;

import com.domain.algo.dto.UserDTO;
import com.domain.algo.entity.Users;
import com.domain.algo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Users addUser(UserDTO userDTO) throws Exception {
        Users user = userRepository.findByEmail(userDTO.getEmail());
        if(user != null) {
            throw new Exception("Email already exist");
        }

        Users users = new Users(userDTO.getUsername(), userDTO.getEmail());
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
