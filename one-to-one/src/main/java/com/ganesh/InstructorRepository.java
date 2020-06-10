package com.ganesh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,  Long>{

}
