package com.ganesh;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
