package com.osbb.service;

import java.util.List;

import com.osbb.model.Osbb;
import com.osbb.model.User;

public interface OsbbService {

	Osbb getOsbbById(String id);
	
	void createOsbb(Osbb osbb);
	
	void updateOsbb(Osbb osbb);
	
	void deleteOsbb(String Id);
	
	void changeMainPerson(User person);
	
	List<Osbb> getAllOsbb();
	
}
