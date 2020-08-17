package com.ganesh.apis.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ganesh.apis.model.User;
import com.ganesh.apis.repository.RoleRepository;
import com.ganesh.apis.repository.UserRepository;
import com.ganesh.apis.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private RoleRepository roleRepo;
	private UserRepository userRepo;
	
    @Autowired
	public UserServiceImpl(RoleRepository roleRepo, UserRepository userRepo) {
		this.roleRepo = roleRepo;
		this.userRepo = userRepo;
	}

	@Override
	public ResponseEntity<Object> createUser(User user) {
		User users = new User();
		if(userRepo.findByEmail(user.getEmail()).isPresent()) {
			return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
		}else {
			users.setFirstName(user.getFirstName());
			users.setLastName(user.getLastName());
			users.setEmail(user.getEmail());
			users.setMobileNo(user.getMobileNo());
			users.setRoles(user.getRoles());
			User savedUser = userRepo.save(users);
			if(userRepo.findById(savedUser.getId()).isPresent()) {
				return ResponseEntity.ok("User Created Successfully");
			}else {
				return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
			}
		}
	}

	@Override
	@Transactional
	public ResponseEntity<Object> updateUser(User user, Long id) {
		if(userRepo.findById(id).isPresent()) {
			User newUser = userRepo.findById(id).get();
			newUser.setFirstName(user.getFirstName());
			newUser.setLastName(user.getLastName());
			newUser.setEmail(user.getEmail());
			newUser.setMobileNo(user.getMobileNo());
			User savedUser = userRepo.save(newUser);
			if(userRepo.findById(savedUser.getId()).isPresent()) {
				return ResponseEntity.accepted().body("User updated successfully");
			}else {
				return ResponseEntity.unprocessableEntity().body("Failed updating the user specified");
			}
		}else {
			return ResponseEntity.unprocessableEntity().body("Cannot find the user specified");
		}
	}

	@Override
	public ResponseEntity<Object> deleteUser(Long id) {
		if(userRepo.findById(id).isPresent()) {
			userRepo.deleteById(id);
			if(userRepo.findById(id).isPresent()) {
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified User");
			}else {
				return ResponseEntity.ok().body("Successfully deleted the specified user");
			}
		}else {
			return ResponseEntity.badRequest().body("Cannot find the user specified");
		}
		
	}

}
