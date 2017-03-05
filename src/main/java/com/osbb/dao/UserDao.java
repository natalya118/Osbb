package com.osbb.dao;

import java.util.List;
import java.util.Set;

import com.osbb.model.Request;
import com.osbb.model.User;


public interface UserDao {

	User findById(Integer integer);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();
	
	int getOsbbIdByUser(User user);

}

