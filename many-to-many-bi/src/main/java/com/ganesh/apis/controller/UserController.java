package com.ganesh.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.apis.model.User;
import com.ganesh.apis.repository.UserRepository;
import com.ganesh.apis.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
    private UserRepository userRepository;
    
    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    
    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return (ResponseEntity<Object>) userService.createUser(user);
    }
    @GetMapping("/user/details/{id}")
    public User getUser(@PathVariable Long id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return  null;
    }
    @GetMapping("/user/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @PutMapping("/user/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return (ResponseEntity<Object>) userService.updateUser(user, id);
    }
    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return (ResponseEntity<Object>) userService.deleteUser(id);
    }


	

}
