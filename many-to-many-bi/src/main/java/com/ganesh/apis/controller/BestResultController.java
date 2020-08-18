package com.ganesh.apis.controller;

import com.ganesh.apis.model.UserModel;
import com.ganesh.apis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BestResultController {

    private UserService userService;

    @Autowired
    public BestResultController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/details/{id}")
    public UserModel getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/users/all")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }
}
