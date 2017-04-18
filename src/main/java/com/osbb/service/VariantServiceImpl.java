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

@Service("variantService")
@Transactional
public class VariantServiceImpl implements VariantService{

	@Autowired
	private VariantDao variantDao;
	




	@Override
	public Variant getVariantById(int id) {
		return variantDao.getVariantById(id);
	}

}
