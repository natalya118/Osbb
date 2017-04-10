package com.osbb.service;

import java.util.List;

import com.osbb.model.House;
import com.osbb.model.Realty;

public interface HouseService {

	House getHouseById(int id);
	
	void saveHouse(House house);
	
	void updateHouse(House house);
	
	void deleteHouse(int id);
	
	List<House> getAllHouses(int osbbId);
	
	
	void generateUsersCredentials(List<Integer> flats, int houseId);
}
