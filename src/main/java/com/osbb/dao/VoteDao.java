package com.osbb.dao;
import com.osbb.model.Vote;
public interface VoteDao {
	Vote getVoteById(int id);

	void save(Vote vote);

//	void deleteById(int id);
//
//	List<Voting> getAllOsbbVotings(int osbbId);
//
//	public boolean voted(int userId, int votingId);

}
