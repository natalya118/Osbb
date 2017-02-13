package com.osbb.model.forum;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "forum_messages")
public class ForumMessage implements Serializable{
	@Id
	@Column(name = "forum_massage_id")
	private String forumMessageId;
	
	@NotNull
	@Column(name = "forum_topic_id")
	private String forumTopicId;
	
	@NotNull
	@Column(name = "author_id")
	private String authorId;
	
	@NotNull
	@Column(name = "message_date")
	private String messageDate;
	
	@NotNull
	@Column(name = "text",length=500)
	private String text;

	public String getForumMessageId() {
		return forumMessageId;
	}

	public void setForumMessageId(String forumMessageId) {
		this.forumMessageId = forumMessageId;
	}

	public String getForumTopicId() {
		return forumTopicId;
	}

	public void setForumTopicId(String forumTopicId) {
		this.forumTopicId = forumTopicId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "ForumMessage [forumMessageId=" + forumMessageId + ", forumTopicId=" + forumTopicId + ", authorId="
				+ authorId + ", messageDate=" + messageDate + ", text=" + text + "]";
	}
	
	
}
