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
@RequestMapping("register/")
public class RegisterController {
	
	@Autowired
	OsbbService osbbService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = { "/newosbb" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		Osbb osbb = new Osbb();
		model.addAttribute("osbb",osbb);
		return "osbb_registration";
	}
	
	/**
	 * This method will provide the medium to add a new user.
	 */


	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newosbb" }, method = RequestMethod.POST)
	public String saveUser(@Valid Osbb osbb, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "osbb_registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
//		if(!osbbService(osbb.getId(), osbb.getOsbbCode())){
//			FieldError ssoError =new FieldError("osbb","osbbCode",messageSource.getMessage("non.unique.osbbCode", new String[]{osbb.getOsbbCode()}, Locale.getDefault()));
//		    result.addError(ssoError);
//			return "registration";
//		}
		
		osbbService.saveOsbb(osbb);

//		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
//		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}

}
