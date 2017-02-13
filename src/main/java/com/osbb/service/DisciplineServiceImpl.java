package com.osbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.DisciplineDao;
import com.osbb.model.Request;


@Service("disciplineService")
@Transactional
public class DisciplineServiceImpl implements DisciplineService{

	@Autowired
	private DisciplineDao dao;



	@Override
	public Request findById(int id) {
		return dao.findDiscById(id);
	}


	@Override
	public void saveDiscipline(Request discipline){
		dao.save(discipline);
	}
	@Override
	public void updateDiscipline(Request discipline) {
		Request entity = dao.findDiscById(discipline.getId());
		if(entity!=null){
			entity.setName(discipline.getName());
			entity.setCredits(discipline.getCredits());
		}
		
	}

	@Override
	public void deleteDiscipline(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Request> findAllDisciplines() {
		return dao.findAllDisciplines();
	}
	
}
