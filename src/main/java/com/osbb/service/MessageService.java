package com.osbb.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.osbb.model.chats.Message;

public interface MessageService {
	void saveMessage(Message message);

}
