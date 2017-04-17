package com.osbb.dao;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osbb.model.Vote;

@Repository("voteDao")
public class VoteDaoImpl extends AbstractDao<Integer, Vote> implements VoteDao {

	@Autowired
	SessionFactory sessionFactory;


	@Override
	public Vote getVoteById(int id) {
		Vote vote = getByKey(id);
		if (vote != null) {
			Hibernate.initialize(vote);
		}
		return vote;
	}

	@Override
	public void save(Vote vote) {
		persist(vote);
		
	}

}
