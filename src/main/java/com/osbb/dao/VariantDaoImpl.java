package com.osbb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.osbb.model.News;
import com.osbb.model.Osbb;
import com.osbb.model.Variant;
import com.osbb.model.Voting;

@Repository("variantDao")
public class VariantDaoImpl extends AbstractDao<Integer, Variant> implements VariantDao {



	@Override
	public void save(Variant variant) {
		persist(variant);
		
	}

	@Override
	public List<Variant> getgetVotingVariants(int votingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variant getVariantById(int id) {
		Variant variant = getByKey(id);
		if (variant != null) {
			Hibernate.initialize(variant);
		}
		return variant;
	}

}
