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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.model.chats.Message;
import com.osbb.service.ChatService;
import com.osbb.service.UserProfileService;
import com.osbb.service.UserService;

@Controller
@SessionAttributes("roles")
public class ChatController {

	@Autowired
	UserService userService;
	 
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ChatService chatService;
	
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
	@RequestMapping(value = { "/", "/all" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<Chat> chats = chatService.getAllChats(userService.findBySSO(getPrincipal()).getId());
		model.addAttribute("chats", chats);
		model.addAttribute("loggedinuser", getPrincipal());
		return "chats";
	}
	
	@RequestMapping(value = { "/", "/mess{chatid}" }, method = RequestMethod.GET)
	public String chatMessages(@PathVariable int chatid, ModelMap model) {

		List<Message> messages = chatService.getChatMessages(1);
		model.addAttribute("messages", messages);
		model.addAttribute("loggedinuser", getPrincipal());
		return "chat_view";
	}
	@MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message mess(String text,int chatid) throws Exception {
        Thread.sleep(1000); // simulated delay
        Message mess = new Message(userService.findBySSO(getPrincipal()).getId(), text, chatid);
        //messageService.saveMessage(mess);
        return mess;
    }
}
