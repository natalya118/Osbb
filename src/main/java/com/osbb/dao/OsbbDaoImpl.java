package com.osbb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.osbb.model.Osbb;

@Repository("osbbDao")
public class OsbbDaoImpl extends AbstractDao<Integer, Osbb> implements OsbbDao {

	static final Logger logger = LoggerFactory.getLogger(OsbbDaoImpl.class);

	@Override
	public Osbb getOsbbById(int id) {
		Osbb osbb = getByKey(id);
		if (osbb != null) {
			Hibernate.initialize(osbb);
		}
		return osbb;
	}


	@Override
	public void saveOsbb(Osbb osbb) {
		persist(osbb);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Osbb> getAllOsbb() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("osbbId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		List<Osbb> osbbs = (List<Osbb>) criteria.list();

		return osbbs;
	}

	@Override
	public Osbb findByCode(String code) {
		logger.info("OsbbCode : {}", code);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("osbbCode", code));
		Osbb osbb = (Osbb) crit.uniqueResult();
		if (osbb != null) {
			Hibernate.initialize(osbb);
		}
		return osbb;
	}

	@Override
	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Osbb osbb = (Osbb) crit.uniqueResult();
		delete(osbb);

	}

	@Override
	public void deleteByCode(String code) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("osbbCode", code));
		Osbb osbb = (Osbb) crit.uniqueResult();
		delete(osbb);

	}

}
