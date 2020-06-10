package com.ganesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ganesh.entity.Instructor;
import com.ganesh.entity.InstructorDetail;
import com.ganesh.repo.InstructorRepository;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {
	
	
    private InstructorRepository instructorRepository;
    
    @Autowired
    public OneToOneApplication(InstructorRepository instructorRepository) {
	  this.instructorRepository = instructorRepository;	
	}


	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}
	
	
	 
	    @Override
	    public void run(String...args) throws Exception {

	        Instructor instructor = new Instructor("Ramesh", "Sir", "ramesh@gmail.com");

	        InstructorDetail instructorDetail = new InstructorDetail("Java Ist", "Cricket Playing");
	        
	        Instructor instructor1 = new Instructor("Ramesh", "Sir", "ramesh@gmail.com");
	        InstructorDetail instructorDetails = new InstructorDetail("Angular", "Cricket Playing");

	        // associate the objects
	        instructor.setInstructorDetails(instructorDetail);

	        instructorRepository.save(instructor);
	        
	        // associate the objects 
	        instructor1.setInstructorDetails(instructorDetails);

	        instructorRepository.save(instructor1);
	    }

}
