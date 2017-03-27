package com.osbb.model.chats;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="chats")
public class Chat implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String topic;

	@Column
	private int osbbId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getOsbbId() {
		return osbbId;
	}

	public void setOsbbId(int osbbId) {
		this.osbbId = osbbId;
	}
	
	//private List<Message> messages;
	

}
