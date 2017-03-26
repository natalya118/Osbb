package com.osbb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.osbb.model.House;
import com.osbb.model.Osbb;
import com.osbb.model.User;
@Repository("houseDao")
public class HouseDaoImpl extends AbstractDao<Integer, House> implements HouseDao{

	public House findById(Integer id){
		House house = getByKey(id);
		return house;
	}


	public void save(House house) {
		persist(house);
		
	}


	@Override
	public House findByUser(User user) {
//		Criteria crit = createEntityCriteria();
//		crit.add(Restrictions.eq("id", user.getId()));
//		return ((User)crit.uniqueResult()).getHouseId();
		return null;
	}


	public int getOsbbId(House house) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<House> findAllHousesByOsbbId(int osbbId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("osbbid", osbbId));
		return crit.list();
	}


	@Override
	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		House house = (House) crit.uniqueResult();
		delete(house);
		
	}






	
}
