package com.osbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.OsbbDao;
import com.osbb.dao.RealtyDao;
import com.osbb.model.Realty;

@Service("realtyService")
@Transactional
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
		realtyDao.deleteById(id);
		
	}

	@Override
	public List<Realty> getAllRealtiesByHouseId(int houseId) {
		return realtyDao.getHouseRealties(houseId);
	}

}
