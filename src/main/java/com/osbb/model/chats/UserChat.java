package com.osbb.model.chats;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table
@IdClass(UserChatId.class)
public class UserChat implements Serializable{
	
	@Id private int userId;
	
	@Id private int chatId;

	public UserChat(int userId, int chatId) {
		
		this.userId = userId;
		this.chatId = chatId;
	}
	

}
