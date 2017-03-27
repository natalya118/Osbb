package com.osbb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.ChatDao;
import com.osbb.dao.MessageDao;
import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.model.chats.Message;

@Service("chatService")
@Transactional
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatDao dao;
	
	@Autowired
	private MessageDao mdao;

	public Chat getChatById(int id) {
		
		return dao.findById(id);
	}


	public void saveChat(Chat chat) {
		dao.save(chat);

	}

	@Override
	public void updateChat(Chat chat) {
		Chat entity = dao.findById(chat.getId());
		if(entity!=null){
			
			entity.setTopic(chat.getTopic());
		}

	}

	@Override
	public void deleteChat(int id) {
		dao.deleteById(id);

	}

	@Override
	public List<Chat> getAllChats(int userid) {
		return dao.findUserChats(userid);
	}


	@Override
	public List<Message> getChatMessages(int chatid) {
		return mdao.getChatMessages(dao.findById(chatid));
	}


	@Override
	public List<User> getChatMembers(int id) {
		return dao.getChatUsers(id);
	}


	@Override
	public void addUserToChat(int chatId, int userId) {
		dao.addUserToChat(chatId, userId);
		
	}

}
