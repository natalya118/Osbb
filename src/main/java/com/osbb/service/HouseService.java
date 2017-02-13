package com.osbb.service;

import java.util.List;

import com.osbb.model.House;

public interface HouseService {

	House getHouseById(String id);
	
	void createHouse(House house);
	
	void updateHouse(House house);
	
	void deleteHouse(String id);
	
	List<House> getAllHouses();
}
