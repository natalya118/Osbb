package com.osbb.dao;

import org.springframework.stereotype.Repository;
import com.osbb.model.chats.UserChat;

@Repository("userChatDao")
public class UserChatDaoImpl extends AbstractDao<Integer, UserChat> implements UserChatDao {

	public void saveUserChat(int chatId, int userId) {
		persist(new UserChat(userId,chatId));

	}

}
