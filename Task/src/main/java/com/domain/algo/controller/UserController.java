package com.domain.algo.controller;

import com.domain.algo.dto.UserDTO;
import com.domain.algo.entity.Users;
import com.domain.algo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) {
        try {
            Users user = userService.addUser(userDTO);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
