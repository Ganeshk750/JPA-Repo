package com.ganesh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.entity.Instructor;
import com.ganesh.exception.ResourceNotFoundException;
import com.ganesh.repo.InstructorRepository;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {
	
	Logger logger = (Logger) LoggerFactory.logger(InstructorController.class);
	
	private InstructorRepository instructorRepository;
	
	@Autowired
	public InstructorController(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}
	
	@GetMapping("/instructors")
    public List < Instructor > getInstructors() {
		 logger.info("---GETALL---"+ logger.getName());
        return instructorRepository.findAll();
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity < Instructor > getInstructorById(
        @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
    	 logger.info("---GETBYID---"+ logger.getName());
        Instructor user = instructorRepository.findById(instructorId)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/instructors")
    public Instructor createUser(@Validated @RequestBody Instructor instructor) {
    	 logger.info("---CREATE---"+ logger.getName());
        return instructorRepository.save(instructor);
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity < Instructor > updateUser(
        @PathVariable(value = "id") Long instructorId,
        @RequestBody Instructor userDetails) throws ResourceNotFoundException {
    	 logger.info("---UPDAREBYID---"+ logger.getName());
        Instructor user = instructorRepository.findById(instructorId)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        user.setEmail(userDetails.getEmail());
        final Instructor updatedUser = instructorRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    
    
    @DeleteMapping("/instructors/{id}")
    public Map < String, Boolean > deleteUser(
        @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
    	 logger.info("---DELETEBYID---"+ logger.getName());
        Instructor instructor = instructorRepository.findById(instructorId)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));

        instructorRepository.delete(instructor);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
