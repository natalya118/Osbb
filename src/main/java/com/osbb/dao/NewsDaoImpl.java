package com.osbb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.osbb.model.News;
import com.osbb.model.Osbb;
@Repository("newsDao")
public class NewsDaoImpl  extends AbstractDao<Integer, News> implements NewsDao{

	public News getNewsById(int id) {
		News news = getByKey(id);
		if (news != null) {
			Hibernate.initialize(news);
		}
		return news;
	}

	public void save(News news) {
		persist(news);
		
	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		News news = (News) crit.uniqueResult();
		delete(news);
		
	}

	@Override
	public List<News> getAllOsbbNews(int osbbId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("osbbId", osbbId));
		List<News> news = (List<News>) crit.list();
		return news;

	}

}
