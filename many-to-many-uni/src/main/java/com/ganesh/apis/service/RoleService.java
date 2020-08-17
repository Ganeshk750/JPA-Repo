package com.ganesh.apis.service;



import com.ganesh.apis.model.Role;

public interface RoleService {
	
	Object addRole(Role role);
	Object deleteRole(Long id);
	Object updateRole(Long id, Role role);
	

}
