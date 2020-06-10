package com.ganesh.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InstructorDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5235844065385694765L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String channelName;
	private String hobby;
	
	public InstructorDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public InstructorDetail(String channelName, String hobby) {
		this.channelName = channelName;
		this.hobby = hobby;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	

}
