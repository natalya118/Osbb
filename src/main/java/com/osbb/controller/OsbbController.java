package com.osbb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.osbb.model.House;
import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.service.HouseService;
import com.osbb.service.OsbbService;
import com.osbb.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class OsbbController {
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	HouseService houseService;
	@Autowired
	UserService userService;
	
	@Autowired
	OsbbService osbbService;
	
	@RequestMapping(value = { "/osbbadmin" }, method = RequestMethod.GET)
	public String Admin(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("osbb",osbbService.getOsbbById(userService.findBySSO(getPrincipal()).getOsbbId()));
		List<House> houses = houseService.getAllHouses(userService.findBySSO(getPrincipal()).getOsbbId());
		model.addAttribute("houses", houses);
		return "osbb-admin";
	}
	
	@RequestMapping(value = { "/newhouse" }, method = RequestMethod.GET)
	public String newhouse(ModelMap model) {
		
		return "osbb-admin";
	}
	
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
}
