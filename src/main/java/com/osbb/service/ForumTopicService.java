package com.osbb.service;

import java.util.List;

import com.osbb.model.forum.ForumTopic;

public interface ForumTopicService {
	ForumTopic getTopicById(String id);
	void createForumTopic(ForumTopic ft);
	void updateForumTopic(ForumTopic ft);
	void deleteForumTopic(String id);
	List<ForumTopic> getAllTopics();
	List<ForumTopic> getAllTopicsByOsbb(String osbb_id);
}
