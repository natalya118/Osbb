package com.osbb.dao;

import java.util.List;

import com.osbb.model.Osbb;
import com.osbb.model.User;

public interface OsbbDao {
	
	Osbb getOsbbById(int id);
	
	void save(Osbb osbb);
	
	void deleteById(int id);
	
	void deleteByCode(String code);
	
	List<Osbb> getAllOsbb();

	Osbb findByCode(String code);
}
