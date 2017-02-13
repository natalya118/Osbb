package com.osbb.service;

import java.util.List;

import com.osbb.model.Realty;

public interface RealtyService {
	Realty getRealtyById(String Id);
	
	void createRealty(Realty realty);
	
	void updateRealty(Realty realty);
	
	void deleteRealtyById(String id);
	
	List<Realty> getAllRealties();
	
	List<Realty> getAllRealtiesByHouseId(String houseId);

}
