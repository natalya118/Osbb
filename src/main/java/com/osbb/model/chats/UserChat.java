package com.osbb.model.chats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserChat {
	
	//TODO implement composite primary key
	@Id
	@Column
	private int userId;
	
	@Column
	private int chatId;
	

}
