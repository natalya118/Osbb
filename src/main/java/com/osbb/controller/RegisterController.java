package com.osbb.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osbb.model.Osbb;
import com.osbb.model.User;
import com.osbb.service.OsbbService;

@Controller
@RequestMapping("/")
public class RegisterController {

	@Autowired
	OsbbService osbbService;

	@Autowired
	MessageSource messageSource;


}
