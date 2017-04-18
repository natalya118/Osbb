package com.osbb.dao;

import java.util.List;

import com.osbb.model.News;
import com.osbb.model.Variant;
import com.osbb.model.Voting;

public interface VotingDao {
	Voting getVotingById(int id);

	void save(Voting voting);

	void deleteById(int id);

	List<Voting> getAllOsbbVotings(int osbbId);

	public boolean voted(int userId, int votingId);
	void completelyLiked(int osbbId);
	public int numberOfVotedUsers(int votingId);
	public double countPercent(Variant v);
}
