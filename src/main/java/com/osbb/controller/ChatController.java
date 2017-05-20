package com.osbb.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.osbb.model.Osbb;
import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.model.chats.MTest;
import com.osbb.model.chats.Message;
import com.osbb.service.ChatService;
import com.osbb.service.MessageService;
import com.osbb.service.UserProfileService;
import com.osbb.service.UserService;
import com.osbb.wrap.Chat_Users;
import com.osbb.wrap.Osbb_Creator;

@Controller
@SessionAttributes("roles")
@RequestMapping("/chats")
public class ChatController {

	@Autowired
	UserService userService;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	ChatService chatService;

	@Autowired
	MessageService messageService;

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@RequestMapping(value = { "/", "/all" }, method = RequestMethod.GET)
	public String all(ModelMap model) {

		List<Chat> chats = chatService.getAllChats(userService.findBySSO(getPrincipal()).getId());
		model.addAttribute("chats", chats);
		model.addAttribute("chat_users", new Chat_Users());
		model.addAttribute("loggedinuser", getPrincipal());
		List<User> users = userService.findAllUsers(userService.findBySSO(getPrincipal()).getOsbbId());
		users.remove(userService.findBySSO(getPrincipal()));
		
		model.addAttribute("allusers", userService.findAllUsers(userService.findBySSO(getPrincipal()).getOsbbId()));
		return "chats";
	}

	@RequestMapping(value = { "/", "/alljson" }, method = RequestMethod.GET)
	@ResponseBody
	public List<Chat> chats(ModelMap model) {

		List<Chat> chats = chatService.getAllChats(1);
		// List<Chat> chats =
		// chatService.getAllChats(userService.findBySSO(getPrincipal()).getId());
		model.addAttribute("chats", chats);
		model.addAttribute("loggedinuser", getPrincipal());
		return chats;
	}
	
//	@RequestMapping(value = { "/newchat" }, method = RequestMethod.GET)
//	public String newChat(ModelMap model) {
//
//
//		model.addAttribute("chat_users", new Chat_Users());
//		//Chat chat = chat_users.getChat();
//		//for
////		User newUser = osbb_creator.getCreator();
////		newUser.setOsbbId(osbb.getId());
////		userService.saveUser(newUser);
//
//
//		model.addAttribute("users", userService.findAllUsers(userService.findBySSO(getPrincipal()).getOsbbId()));
//		model.addAttribute("loggedinuser", getPrincipal());
//
//		return "chats";
//	}
	
	@RequestMapping(value = { "/newchat" }, method = RequestMethod.POST)
	public String newChat(@Valid Chat_Users chat_users, BindingResult result, ModelMap model) {

		Chat chat = new Chat();
		chat.setTopic(chat_users.getNewChatTopic());
		chat.setOsbbId(userService.findBySSO(getPrincipal()).getOsbbId());
		chatService.saveChat(chat);
		String[] items = chat_users.getUstr().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
		for (int i = 0; i < items.length; i++) {
			chatService.addUserToChat(chat.getId(), userService.findBySSO(items[i]).getId());
		}
		//chatService.addUserToChat(chat.getId(), userService.findBySSO(getPrincipal()).getId());
		List<Chat> chats = chatService.getAllChats(userService.findBySSO(getPrincipal()).getId());
		model.addAttribute("chats", chats);
		model.addAttribute("chat_users", new Chat_Users());
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("allusers", userService.findAllUsers(userService.findBySSO(getPrincipal()).getOsbbId()));
		
		return "redirect:/chats/all";
	}

//	@RequestMapping(value = { "/newchat" }, method = RequestMethod.POST)
//	public String saveOsbb(@Valid Chat chat, BindingResult result, ModelMap model) {
//
//
//		User newUser = osbb_creator.getCreator();
//		newUser.setOsbbId(osbb.getId());
//		userService.saveUser(newUser);
//
//		model.addAttribute("loggedinuser", getPrincipal());
//
//		return "test";
//	}

	@RequestMapping(value = { "/", "/{chatid}" }, method = RequestMethod.GET)
	public String chatMessages(@PathVariable int chatid, ModelMap model) {

		System.out.println(chatService.getChatMembers(chatid).toString());
		try{
			chatService.getChatMembers(chatid);
			if(chatService.getChatMembers(chatid).size()==0){
				return "redirect:/chats/all";
			}
		}
		catch(Exception e){
			return "redirect:/chats/all";
		}
		if(!chatService.getChatMembers(chatid).contains(userService.findBySSO(getPrincipal()))){
			if(!userService.findBySSO(getPrincipal()).equals(chatService.getChatMembers(chatid).get(0))){
				System.out.println("--------**************************");
			}
			System.out.println("----------------------------------------------------"+ chatService.getChatMembers(chatid).get(0).getSsoId());
			return "redirect:/chats/all";
		}
		List<Message> messages = chatService.getChatMessages(chatid);
		for(Message m:messages){
			if(m.getAuthorId()==userService.findBySSO(getPrincipal()).getId())
				m.set—urUserMessage(true);
			else
				m.set—urUserMessage(false);
		}

		model.addAttribute("messages", messages);
		Chat chat = chatService.getChatById(chatid);
		model.addAttribute("chat", chat);
		model.addAttribute("loggedinuser", getPrincipal());

		return "chat_view";

	}

	@MessageMapping("/chat/{id}")
	@SendTo("/topic/messages/{id}")
	public Message mess(@DestinationVariable String id, final Message mess) throws Exception {
		mess.setDateAdded(new Date());
		mess.setChatId(Integer.parseInt(id));


		messageService.saveMessage(mess);

		return mess;

	}
}
