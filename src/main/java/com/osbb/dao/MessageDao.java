package com.osbb.dao;

import java.util.List;

import com.osbb.model.chats.Chat;
import com.osbb.model.chats.Message;


public interface MessageDao {
	Message findById(Integer id);

	void save(Message chat);

	void deleteById(int id);

	List<Message> getChatMessages(Chat chat);

}
