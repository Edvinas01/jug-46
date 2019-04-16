package com.edd.jug46.spring.controller;

import com.edd.jug46.spring.domain.User;
import com.edd.jug46.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService users;

    public UserController(UserService users) {
        this.users = users;
    }

    @GetMapping("/direct")
    public List<User> getUsersDirect() {
        return users.getUsers();
    }

    @GetMapping("/kotlin")
    public List<KUserModel> getKUsers() {
        return KUserMapper.map(users.getUsers());
    }

    @GetMapping
    public List<UserModel> getUsers() {
        return UserMapper.map(users.getUsers());
    }
}
