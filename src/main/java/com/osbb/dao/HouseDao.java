package com.osbb.dao;

import java.util.List;

import com.osbb.model.House;
import com.osbb.model.User;

public interface HouseDao {
	House findById(Integer integer);
	
	void save(House user);
	
	void deleteById(int id);
	
	House findByUser(User user);
	
	int getOsbbId(House house);

	List<House> findAllHousesByOsbbId(int osbbId);
	
	int getNumberOfFlats(int houseId);

	

}
