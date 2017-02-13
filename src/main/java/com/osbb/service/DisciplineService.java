package com.osbb.service;

import java.util.List;

import com.osbb.model.Request;


public interface DisciplineService {
	
	Request findById(int id);
	
	void saveDiscipline(Request discipline);
	
	void updateDiscipline(Request discipline);
	
	void deleteDiscipline(int id);

	List<Request> findAllDisciplines(); 

}