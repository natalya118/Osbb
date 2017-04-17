package com.osbb.dao;

import java.util.List;

import com.osbb.model.Variant;

public interface VariantDao {

	void save(Variant variant);

	List<Variant> getgetVotingVariants(int votingId);
	

}
