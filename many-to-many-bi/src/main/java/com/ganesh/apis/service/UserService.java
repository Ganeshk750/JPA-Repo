package com.ganesh.apis.service;

import com.ganesh.apis.model.User;

public interface UserService {
	
	Object createUser(User user);
	Object updateUser(User user, Long id);
	Object deleteUser(Long id);

}