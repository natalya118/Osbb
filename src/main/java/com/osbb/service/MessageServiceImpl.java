package com.osbb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.osbb.dao.MessageDao;
import com.osbb.dao.MessageDaoImpl;
import com.osbb.model.chats.Message;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService
{
@Autowired
MessageDao dao;
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void saveMessage(Message message) {
		dao.save(message);
		
	}



}
