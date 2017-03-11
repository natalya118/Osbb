package com.osbb.model.chats;

import java.sql.Date;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
@Transactional
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "message_id")
	private int messageId;

	public Message(){
		
	}
	public Message(int author, String text, int chatid){
		this.authorId = author;
		this.messageText = text;
		this.chatId = chatid;
		
	}
	//@NotEmpty
	@Column(name = "chat_id")
	private int chatId;

	//@NotEmpty
	@Column(name = "author_id")
	private int authorId;

	@NotEmpty
	@Column(name = "message_text", length = 800)
	private String messageText;

	//@NotEmpty
//	@Column(name = "date_added")
//	private Date dateAdded;

	@Column(name = "date_changed")
	private Date dateChanged;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

//	public Date getDateAdded() {
//		return dateAdded;
//	}
//
//	public void setDateAdded(Date dateAdded) {
//		this.dateAdded = dateAdded;
//	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", chatId=" + chatId + ", authorId=" + authorId + ", messageText="
				+ messageText + ", dateAdded=" + 
//				dateAdded + 
				", dateChanged=" + dateChanged + "]";
	}

}
