package com.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.osbb.service.HouseService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class OsbbController {
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	HouseService houseService;
	
	
}
