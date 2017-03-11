package com.osbb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osbb.model.chats.Message;
import com.osbb.service.MessageService;
import com.osbb.service.UserProfileService;
import com.osbb.service.UserService;

@Controller
public class MessageController {
	@Autowired
	UserService userService;
	 
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	MessageService messageService;
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	//TODO get chat id dynamically from url
//	@MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public Message mess(String text,int chatid) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        Message mess = new Message(userService.findBySSO(getPrincipal()).getId(), text, chatid);
//        messageService.saveMessage(mess);
//        return mess;
//    }

}
