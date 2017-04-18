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
			System.out.println("SAVED: " + var.getId() + var.getVariant());
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
						+ "INNER JOIN variant.votes vote  " + "WHERE vote.userId = " + userId + " AND voting.id = "
						+ votingId + " GROUP BY userId");
		try {
			int count = (int) (long) query.uniqueResult();
		} catch (NullPointerException e) {
			return false;
		}

		return true;

	}

	public void completelyLiked(int osbbId) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT variant.id FROM Variant variant "
				+ "WHERE NOT EXISTS (SELECT u.id FROM User u WHERE u.osbbId = " + osbbId
				+ " AND NOT EXISTS (SELECT vote.userId FROM Vote vote WHERE vote.userId = u.id AND vote.variant.id = variant.id))");
		List count = query.list();
		System.out.println("-----------------------------------------------------------------LIKED------");

		System.out.println(count);
	}

	public int numberOfVotedUsers(int votingId) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT COUNT(*) FROM Voting voting " + "INNER JOIN voting.variants variant  "
						+ "INNER JOIN variant.votes vote  " + "WHERE voting.id = " + votingId + " GROUP BY voting.id");
		try {
			int count = (int) (long) query.uniqueResult();
			return count;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public int numberOfVotedForVariant(int variantId) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT COUNT(*) FROM Voting voting " + "INNER JOIN voting.variants variant  "
						+ "INNER JOIN variant.votes vote  " + "WHERE vote.variant.id = " + variantId
						+ " GROUP BY userId");
		try {
			int count = (int) (long) query.uniqueResult();
			return count;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public double countPercent(Variant v) {
		if (numberOfVotedUsers(v.getVoting().getId()) > 0)
			return numberOfVotedForVariant(v.getId()) * 100 / numberOfVotedUsers(v.getVoting().getId());
		else
			return 0;

	}

}
