package com.osbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.NewsDao;
import com.osbb.dao.VariantDao;
import com.osbb.dao.VotingDao;
import com.osbb.model.News;
import com.osbb.model.Variant;
import com.osbb.model.Voting;

@Service("votingService")
@Transactional
public class VotingServiceImpl implements VotingService{

	@Autowired
	private VotingDao votingDao;
	
	@Autowired
	private VariantDao variantDao;



	@Override
	public Voting getVotingById(int id) {
		return votingDao.getVotingById(id);
	}

	@Override
	public void saveVoting(Voting voting) {
		votingDao.save(voting);
		for(Variant v: voting.getVariants()){
			v.setVoting(voting);
			variantDao.save(v);
		}
		
		
	}

	@Override
	public void deleteVoting(int id) {
		votingDao.deleteById(id);
		
	}

	@Override
	public List<Voting> getAllVotingsByOsbbId(int osbbId) {
		return votingDao.getAllOsbbVotings(osbbId);
	}

	@Override
	public boolean voted(int userId, int votingId) {
		return votingDao.voted(userId, votingId);
	}

	@Override
	public void completelyLiked(int osbbId) {
		votingDao.completelyLiked(osbbId);
		
	}
	
	public int numberOfVotedUsers(int votingId){
		return votingDao.numberOfVotedUsers(votingId);
	}
	
	public double countPercent(Variant v){
		return votingDao.countPercent(v);
	}

}
