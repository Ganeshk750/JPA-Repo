package com.ganesh.apis.service.impl;

import com.ganesh.apis.model.Role;
import com.ganesh.apis.repository.RoleRepository;
import com.ganesh.apis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	
	private RoleRepository roleRepo;
	 
    @Autowired
	public RoleServiceImpl(RoleRepository roleRepo) {
		this.roleRepo = roleRepo;
	}

	@Override
	public ResponseEntity<Object> addRole(Role role) {
		Role newRole = new Role();
		newRole.setName(role.getName());
		newRole.setDescription(role.getDescription());
		Role savedRole = roleRepo.save(newRole);
		if(roleRepo.findById(savedRole.getId()).isPresent()) {
			return ResponseEntity.accepted().body("Successfully Created Role ");
		}else {
			return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
		}
		
	}

//	@Override
//	public ResponseEntity<Object> deleteRole(Long id) {
//		if(roleRepo.findById(id).isPresent()) {
//			roleRepo.deleteById(id);
//			if(roleRepo.findById(id).isPresent()) {
//				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
//			}else {
//				return ResponseEntity.ok().body("Successfully deleted specified record");
//			}
//		}else {
//			return ResponseEntity.unprocessableEntity().body("No Records Found");
//		}
//	}

	@Override
	public ResponseEntity<Object> deleteRole(Long id) {
    	if(roleRepo.findById(id).isPresent()){
    		if(roleRepo.getOne(id).getUsers().size() == 0){
               roleRepo.deleteById(id);
               if(roleRepo.findById(id).isPresent()){
               	return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
			   }else{
               	return ResponseEntity.ok().body("Successfully deleted specified record");
			   }
			}else{
    			return ResponseEntity.unprocessableEntity().body("Failed to delete Please delete the users associated with role");
			}
		}else{
    		return ResponseEntity.unprocessableEntity().body("No Records founds");
		}
	}

	@Override
	public ResponseEntity<Object> updateRole(Long id, Role role) {
		if(roleRepo.findById(id).isPresent()) {
			Role newRole = roleRepo.findById(id).get();
			newRole.setName(role.getName());
			newRole.setDescription(role.getDescription());
			Role savedRole = roleRepo.save(newRole);
			if(roleRepo.findById(id).isPresent()) {
				return ResponseEntity.accepted().body("Role saved successfully");
			}else {
				return ResponseEntity.badRequest().body("Faild to update Role");
			}
		}else {
			return ResponseEntity.unprocessableEntity().body("Specified Role not found");
		}
	}

}
