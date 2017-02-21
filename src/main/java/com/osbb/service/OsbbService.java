package com.osbb.service;

import java.util.List;

import com.osbb.model.Osbb;
import com.osbb.model.User;

public interface OsbbService {

	Osbb getOsbbById(int id);
	
	Osbb getOsbbByCode(String code);
	
	void updateOsbb(Osbb osbb);
	
	void saveOsbb(Osbb osbb);
	
	void deleteOsbb(int id);
	
	List<Osbb> getAllOsbb();
	
	boolean isOsbbCodeUnique(int id, String code);
	
}
