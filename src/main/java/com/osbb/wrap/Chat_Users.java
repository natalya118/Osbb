package com.osbb.wrap;

import java.util.ArrayList;
import java.util.List;
import com.osbb.model.chats.Chat;

public class Chat_Users {
	public String newChatTopic;
	//public final List<Integer> users;
	public String ustr;

	public Chat_Users() {
		
	}
//
//	public Chat_Users(int chat, List<Integer> chatuser) {
//
//		this.chatId = chat;
//		this.users = chatuser;
//	}
//
//	public int getChat() {
//		return chatId;
//	}
//
//	public List<Integer> getChatuser() {
//		return users;
//	}

	public String getNewChatTopic() {
		return newChatTopic;
	}

	public String getUstr() {
		return ustr;
	}

	public void setNewChatTopic(String newChatTopic) {
		this.newChatTopic = newChatTopic;
	}

	public void setUstr(String ustr) {
		this.ustr = ustr;
	}
	

//	public int getChatId() {
//		return chatId;
//	}
//
//	public String getUstr() {
//		return ustr;
//	}
	

}
