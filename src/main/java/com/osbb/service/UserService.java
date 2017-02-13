package com.osbb.service;

import java.util.List;
import java.util.Set;

import com.osbb.model.Request;
import com.osbb.model.User;


public interface UserService {
	
	User findById(int id);
	
	User findBySSO(String sso);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserBySSO(String sso);
	
	void applyForDisc(Request discipline);

	List<User> findAllUsers(); 
	
	Set<Request> getStudDisc(String sso);
	boolean isUserSSOUnique(Integer id, String sso);


}