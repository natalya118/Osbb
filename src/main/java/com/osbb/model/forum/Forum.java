package com.osbb.model.forum;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "forums")
public class Forum implements Serializable{
	@Id
	@Column(name="forum_id")
	private String forumId;
	
	@NotNull
	@Column(name="osbb_id")
	private String osbbId;

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getOsbbId() {
		return osbbId;
	}

	public void setOsbbId(String osbbId) {
		this.osbbId = osbbId;
	}
	
	
}
