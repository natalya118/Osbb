package com.osbb.service;

import java.util.List;

import com.osbb.model.Realty;

public interface RealtyService {
	Realty getRealtyById(int Id);
	
	void createRealty(Realty realty);
	
	void updateRealty(Realty realty);
	
	void deleteRealtyById(int id);
	
	List<Realty> getAllRealtiesByHouseId(int houseId);

}
