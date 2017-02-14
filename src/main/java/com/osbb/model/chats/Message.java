package com.osbb.model.chats;

import javax.persistence.Column;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "messages")
public class Message {

	@Id
	@Column(name = "message_id")
	private String messageId;

	@NotEmpty
	@Column(name = "chat_id")
	private String chatId;

	@NotEmpty
	@Column(name = "author_id")
	private String authorId;

	@NotEmpty
	@Column(name = "message_text", length = 800)
	private String messageText;

	@NotEmpty
	@Column(name = "date_added")
	private Date dateAdded;

	@Column(name = "date_changed")
	private Date dateChanged;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", chatId=" + chatId + ", authorId=" + authorId + ", messageText="
				+ messageText + ", dateAdded=" + dateAdded + ", dateChanged=" + dateChanged + "]";
	}

}
