package com.osbb.dao;

import java.util.List;

import com.osbb.model.Realty;

public interface RealtyDao {
	Realty getRealtyById(int id);

	void save(Realty realty);

	void deleteById(int id);

	List<Realty> getHouseRealties(int houseId);

}
