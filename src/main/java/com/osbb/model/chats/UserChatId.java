package com.osbb.model.chats;

import java.io.Serializable;

public class UserChatId implements Serializable{

	private int userId;

	private int chatId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chatId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserChatId other = (UserChatId) obj;
		if (chatId != other.chatId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	
	
}
