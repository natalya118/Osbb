package com.osbb.service;

import java.util.List;

import com.osbb.model.forum.Forum;

public interface ForumService {
	Forum getForumById(String id);

	void createForum(Forum forum);

	void updateForum(Forum forum);

	void deleteForum(String id);

	List<Forum> getAllForums();

}
