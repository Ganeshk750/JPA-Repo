package com.ganesh.apis.service;

import com.ganesh.apis.model.RoleModel;
import com.ganesh.apis.model.User;
import com.ganesh.apis.model.UserModel;

import java.util.List;

public interface UserService {
	
	Object createUser(User user);
	Object updateUser(User user, Long id);
	Object deleteUser(Long id);

     /* Adding new methods*/
	 UserModel getUser(Long id);
	 List<UserModel > getUsers();
	 List<RoleModel> getRoleList(User user);
}