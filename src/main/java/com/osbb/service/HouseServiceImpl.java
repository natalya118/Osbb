package com.osbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.HouseDao;
import com.osbb.model.House;


@Service("houseService")
@Transactional
public class HouseServiceImpl implements HouseService{
	@Autowired
	private HouseDao dao;

	@Override
	public House getHouseById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveHouse(House house) {
		dao.save(house);
		
	}

	@Override
	public void updateHouse(House house) {
		House entity = dao.findById(house.getHouseId());
		if(entity!=null){
			entity.setStreet(house.getStreet());
			entity.setNumber(house.getNumber());
		}
		
	}

	@Override
	public void deleteHouse(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<House> getAllHouses() {
		// TODO Auto-generated method stub
		return null;
	}
}
