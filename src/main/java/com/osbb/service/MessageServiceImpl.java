package com.osbb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.osbb.dao.MessageDaoImpl;
import com.osbb.model.chats.Message;

@Service("messageService")
public class MessageServiceImpl implements MessageService
{
@Autowired
MessageDaoImpl dao;
	@Override
	public void saveMessage(Message message) {
		dao.persist(message);
		
	}



}
