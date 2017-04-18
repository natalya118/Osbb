package com.osbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.NewsDao;
import com.osbb.dao.VariantDao;
import com.osbb.dao.VoteDao;
import com.osbb.dao.VotingDao;
import com.osbb.model.News;
import com.osbb.model.Variant;
import com.osbb.model.Vote;
import com.osbb.model.Voting;

@Service("voteService")
@Transactional
public class VoteServiceImpl implements VoteService{

	@Autowired
	private VoteDao voteDao;
	




	@Override
	public Vote getVoteById(int id) {
		return voteDao.getVoteById(id);
	}

	@Override
	public void saveVote(Vote vote) {
		voteDao.save(vote);
		
	}

	@Override
	public void vote(int userId, int variantId) {
		// TODO Auto-generated method stub
		
	}

}
