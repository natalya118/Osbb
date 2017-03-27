package com.osbb.service;

import java.util.List;

import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.model.chats.Message;

public interface ChatService {
	
	Chat getChatById(int id);

	void saveChat(Chat Chat);

	void updateChat(Chat Chat);

	void deleteChat(int id);

	List<Chat> getAllChats(int userid);
	
	List<Message> getChatMessages(int chatid);
	
	List<User> getChatMembers(int id);
	
	void addUserToChat(int chatId, int userId);
}
