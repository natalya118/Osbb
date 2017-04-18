package com.osbb.service;

import java.util.List;

import com.osbb.model.News;
import com.osbb.model.Vote;
import com.osbb.model.Voting;

public interface VoteService {
	Vote getVoteById(int id);
	void saveVote(Vote vote);
	void vote(int userId, int variantId);
}
