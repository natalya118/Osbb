package com.osbb.dao;

import java.util.List;

import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.model.chats.Message;

public interface ChatDao {

	Chat findById(Integer integer);

	void save(Chat chat);

	void deleteById(int id);

	List<User> getChatUsers(int id);
	List<Chat> findUserChats(int userid);
	
	List<Message> getChatMessages(int chatid);
	
	void addUserToChat(int chatId, int userId);
	//void updateChat
	
	
}
