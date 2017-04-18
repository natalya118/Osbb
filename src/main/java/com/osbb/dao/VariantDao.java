package com.osbb.dao;

import java.util.List;

import com.osbb.model.Variant;

public interface VariantDao {

	Variant getVariantById(int id);

	void save(Variant variant);

	List<Variant> getgetVotingVariants(int votingId);

}
