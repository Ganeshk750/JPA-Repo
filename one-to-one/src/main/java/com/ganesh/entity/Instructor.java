package com.ganesh.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Instructor implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -8250693869513551428L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fristName;
	
	private String lastName;
	
	private String email;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetails;
	
	
	public Instructor() {
		// TODO Auto-generated constructor stub
	}
	

	public Instructor(String fristName, String lastName, String email) {
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public InstructorDetail getInstructorDetails() {
		return instructorDetails;
	}

	public void setInstructorDetails(InstructorDetail instructorDetails) {
		this.instructorDetails = instructorDetails;
	}
	
	

}
