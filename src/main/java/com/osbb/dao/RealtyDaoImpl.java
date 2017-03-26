package com.osbb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.osbb.model.Osbb;
import com.osbb.model.Realty;


@Repository("realtyDao")
public class RealtyDaoImpl extends AbstractDao<Integer, Realty> implements RealtyDao{

	@Override
	public Realty getRealtyById(int id) {
		Realty realty = getByKey(id);
		if(realty!=null)
			Hibernate.initialize(realty);
		return realty;
	}

	@Override
	public void save(Realty realty) {
		persist(realty);
		
	}

	@Override
	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("realty_id", id));
		Realty realty = (Realty) crit.uniqueResult();
		delete(realty);
		
	}

	@Override
	public List<Realty> getHouseRealties(int houseId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("house_id", houseId));
		return crit.list();
	}

}
