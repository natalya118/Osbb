package com.osbb.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.osbb.model.News;
import com.osbb.model.chats.Chat;
import com.osbb.service.ChatService;
import com.osbb.service.MessageService;
import com.osbb.service.NewsService;
import com.osbb.service.UserProfileService;
import com.osbb.service.UserService;
import com.osbb.wrap.Chat_Users;

@Controller
@SessionAttributes("roles")
@RequestMapping("/news")
public class NewsController {
	@Autowired
	UserService userService;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	NewsService newsService;
	
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
	public String listNews(ModelMap model) {
		List<News> news = newsService.getAllNewsByOsbb(userService.findBySSO(getPrincipal()).getOsbbId());
		model.addAttribute("news", news);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("addnews", new News());
		model.addAttribute("delNews", new News());
		return "news";
	}

	@RequestMapping(value = { "/newnews" }, method = RequestMethod.POST)
	public String addNews(@Valid News addnews, BindingResult result, ModelMap model) {

		addnews.setOsbbId(userService.findBySSO(getPrincipal()).getOsbbId());
		addnews.setAuthorId(userService.findBySSO(getPrincipal()).getId());
		addnews.setDate(new Timestamp(System.currentTimeMillis()));
		newsService.saveNews(addnews);
		
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/news/all";
	}
	
	@RequestMapping(value = { "/delnews/{id}" }, method = RequestMethod.GET)
	public String deleteNews(@PathVariable String id){
		System.out.println("------------------------------------------------------------");
		System.out.println("HERE---------------------------------------");
		newsService.deleteNews(Integer.parseInt(id));
		return "test";
	}


}
