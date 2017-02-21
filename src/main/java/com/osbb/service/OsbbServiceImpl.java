package com.osbb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.OsbbDao;
import com.osbb.model.Osbb;

@Service("osbbService")
@Transactional
public class OsbbServiceImpl implements OsbbService{

	private OsbbDao dao;
	@Override
	public Osbb getOsbbById(int id) {
		return dao.getOsbbById(id);
	}

	@Override
	public Osbb getOsbbByCode(String code) {
		return dao.findByCode(code);
	}


	@Override
	public void saveOsbb(Osbb osbb) {
		dao.saveOsbb(osbb);
		
	}

	@Override
	public void updateOsbb(Osbb osbb) {
		Osbb entity = dao.getOsbbById(osbb.getId());
		if(entity!=null){
			entity.setName(osbb.getName());
			entity.setCreatorId(osbb.getCreatorId());
			entity.setMainPersonId(osbb.getMainPersonId());
			entity.setOsbbCode(osbb.getOsbbCode());
			entity.setCity(osbb.getCity());
			entity.setDateCreated(osbb.getDateCreated());
		}
		
	}

	@Override
	public void deleteOsbb(int Id) {
		dao.deleteById(Id);
		
	}


	@Override
	public List<Osbb> getAllOsbb() {
		return dao.getAllOsbb();
	}

	@Override
	public boolean isOsbbCodeUnique(int id, String code) {
		Osbb osbb = getOsbbByCode(code);
		return ( osbb == null || (osbb.getId() == id));
	}






}
