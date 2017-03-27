package com.osbb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osbb.dao.UserChatDao;

@Service("userChatService")
public class UserChatServiceImpl implements UserChatService {

	@Autowired
	UserChatDao userChatDao;

	@Override
	public void addUserToChat(int userId, int chatId) {
		userChatDao.saveUserChat(chatId, userId);

	}

}
