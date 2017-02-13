package com.osbb.model;

import java.io.Serializable;

public enum UserRequestType implements Serializable{
	COMPLAINT("COMPLAINT"),
	PROPOSITION("PROPOSITION");
	
	String userRequestType;
	
	private UserRequestType(String userRequestType){
		this.userRequestType = userRequestType;
	}
	
	public String getUserRequestType(){
		return userRequestType;
	}
	
}
