package com.osbb.service;

import java.util.List;

import com.osbb.model.News;
import com.osbb.model.Voting;

public interface VoteService {
	Voting getVotingById(int id);
	void saveVoting(Voting voting);
	void deleteVoting(int id);
	List<Voting> getAllVotingsByOsbbId(int osbbId);
	boolean voted(int userId, int votingId);
}
