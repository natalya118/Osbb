package com.osbb.model.forum;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="forum_topics")
public class ForumTopic implements Serializable {

	@Id
	@Column(name="forum_topic_id")
	private String ForumTopicId;
	
	@NotNull
	@Column(name="osbb_id")
	private String osbbId;
	
	@NotNull
	@Column(name="topic_creator_id")
	private String topicCreatorId;
	
	@NotNull
	@Column(name="topic_title",length=140)
	private String topicTitle;
	
	@NotNull
	@Column(name="date_created")
	private Date dateCreated;

	public String getForumTopicId() {
		return ForumTopicId;
	}

	public void setForumTopicId(String forumTopicId) {
		ForumTopicId = forumTopicId;
	}

	public String getOsbbId() {
		return osbbId;
	}

	public void setOsbbId(String osbbId) {
		this.osbbId = osbbId;
	}

	public String getTopicCreatorId() {
		return topicCreatorId;
	}

	public void setTopicCreatorId(String topicCreatorId) {
		this.topicCreatorId = topicCreatorId;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "ForumTopic [ForumTopicId=" + ForumTopicId + ", osbbId=" + osbbId + ", topicCreatorId=" + topicCreatorId
				+ ", topicTitle=" + topicTitle + ", dateCreated=" + dateCreated + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ForumTopicId == null) ? 0 : ForumTopicId.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((osbbId == null) ? 0 : osbbId.hashCode());
		result = prime * result + ((topicCreatorId == null) ? 0 : topicCreatorId.hashCode());
		result = prime * result + ((topicTitle == null) ? 0 : topicTitle.hashCode());
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
		ForumTopic other = (ForumTopic) obj;
		if (ForumTopicId == null) {
			if (other.ForumTopicId != null)
				return false;
		} else if (!ForumTopicId.equals(other.ForumTopicId))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (osbbId == null) {
			if (other.osbbId != null)
				return false;
		} else if (!osbbId.equals(other.osbbId))
			return false;
		if (topicCreatorId == null) {
			if (other.topicCreatorId != null)
				return false;
		} else if (!topicCreatorId.equals(other.topicCreatorId))
			return false;
		if (topicTitle == null) {
			if (other.topicTitle != null)
				return false;
		} else if (!topicTitle.equals(other.topicTitle))
			return false;
		return true;
	}
	
	
}
