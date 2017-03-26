package com.osbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osbb.dao.OsbbDao;
import com.osbb.dao.RealtyDao;
import com.osbb.model.Realty;

@Service("realtyService")
public class RealtyServiceImpl implements RealtyService {

	@Autowired
	private RealtyDao realtyDao;
	@Override
	public Realty getRealtyById(int Id) {
		return realtyDao.getRealtyById(Id);
	}

	@Override
	public void createRealty(Realty realty) {
		realtyDao.save(realty);
		
	}

	@Override
	public void updateRealty(Realty realty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRealtyById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Realty> getAllRealtiesByHouseId(String houseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
