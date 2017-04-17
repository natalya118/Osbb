package com.osbb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osbb.model.News;
import com.osbb.model.Osbb;
import com.osbb.model.Variant;
import com.osbb.model.Voting;

@Repository("votingDao")
public class VotingDaoImpl extends AbstractDao<Integer, Voting> implements VotingDao {
	@Autowired
	VariantDao variantDao;

	@Autowired
	SessionFactory sessionFactory;

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Voting voting = (Voting) crit.uniqueResult();
		delete(voting);

	}

	@Override
	public Voting getVotingById(int id) {
		Voting voting = getByKey(id);
		if (voting != null) {
			Hibernate.initialize(voting);
		}
		return voting;
	}

	@Override
	public void save(Voting voting) {

		System.out.println("SAVING___________________");
		persist(voting);
		for (Variant var : getVotingById(voting.getId()).getVariants()) {
			var.setVoting(voting);
			
			variantDao.save(var);
			System.out.println("SAVED: " + var.getId()+var.getVariant());
		}
	}

	@Override
	public List<Voting> getAllOsbbVotings(int osbbId) {
		Criteria crit = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.add(Restrictions.eq("osbbId", osbbId));
		List<Voting> votings = (List<Voting>) crit.list();
		return votings;
	}

	public boolean voted(int userId, int votingId) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT COUNT(*) FROM Voting voting " + "INNER JOIN voting.variants variant  "
						+ "INNER JOIN variant.votes vote  " + "WHERE vote.userId = " + userId
						+ " AND voting.id = " + votingId + " GROUP BY userId");
		try{
			int count = (int) (long) query.uniqueResult();
		}catch(NullPointerException e){
			return false;
		}
		
			return true;
		
	}

}
