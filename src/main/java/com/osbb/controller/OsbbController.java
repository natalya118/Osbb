package com.osbb.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.osbb.model.House;
import com.osbb.model.Realty;
import com.osbb.model.User;
import com.osbb.model.chats.Chat;
import com.osbb.service.HouseService;
import com.osbb.service.OsbbService;
import com.osbb.service.RealtyService;
import com.osbb.service.UserService;
import com.osbb.wrap.NewHouse;

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

	@Autowired
	RealtyService realtyService;

	@RequestMapping(value = { "/osbbadmin" }, method = RequestMethod.GET)
	public String Admin(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());

		model.addAttribute("osbb", osbbService.getOsbbById(userService.findBySSO(getPrincipal()).getOsbbId()));
		List<House> houses = houseService.getAllHouses(userService.findBySSO(getPrincipal()).getOsbbId());
		model.addAttribute("houses", houses);

		model.addAttribute("newhouse", new NewHouse());
		return "osbb-admin";
	}

	@RequestMapping(value = { "/newhouse" }, method = RequestMethod.POST)
	public String newHouse(@Valid NewHouse newhouse, BindingResult result, ModelMap model) {


		House house = new House();
		house.setNumber(newhouse.getNumber());
		house.setStreet(newhouse.getStreet());
		house.setOsbbid((osbbService.getOsbbById(userService.findBySSO(getPrincipal()).getOsbbId())).getId());
		houseService.saveHouse(house);
		int flatsFrom = Integer.parseInt(newhouse.getFlatsFrom());
		int flatsTo = Integer.parseInt(newhouse.getFlatsTo());
		List<Realty> realties = new ArrayList<Realty>();
		for (int i = flatsFrom; i <=flatsTo; i++) {
			User newUser = new User();
			String sss = house.getId()+"_"+newhouse.getStreet() + newhouse.getNumber() + "_" + Integer.toString(i);
			
			newUser.setSsoId(sss);
			newUser.setPassword(new RandomString(20).nextString());
			newUser.setOsbbId(house.getOsbbid());
			userService.saveUser(newUser);

			Realty newRealty = new Realty();
			newRealty.setRealtyNumber(i);
			newRealty.setRealtyOwnerId(newUser.getId());
			newRealty.setHouse(house);
			newRealty.setOwner(newUser);

			realtyService.createRealty(newRealty);
			realties.add(newRealty);
			newUser.setRealty(newRealty);
			userService.updateUser(newUser);

		}
		Collections.sort(realties,new Comparator<Realty>() {
	         @Override
	        public int compare(Realty r1, Realty r2) {
	                return Integer.compare(r1.getRealtyNumber(), r2.getRealtyNumber());
	        }
	    });
		TreeSet<Realty> foo = new TreeSet<Realty>(realties);
		house.setRealties(foo);

		houseService.updateHouse(house);
		Document document = new Document();
		try {
			@SuppressWarnings("unused")
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("D:/houses.pdf"));
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (DocumentException e1) {
			
			e1.printStackTrace();
		}
		document.open();
		for(Realty r: house.getRealties()){
		Paragraph paragraph1 = new Paragraph("Ћог≥н: "+r.getOwner().getSsoId());
		Paragraph paragraph2 = new Paragraph("ѕароль: "+r.getOwner().getPassword());
		paragraph1.setIndentationLeft(80);
		paragraph1.setIndentationRight(80);
		paragraph1.setAlignment(Element.ALIGN_CENTER);
		paragraph1.setSpacingAfter(15);
		paragraph2.setSpacingBefore(15);
		paragraph2.setAlignment(Element.ALIGN_LEFT);

		
		try {
			document.add(paragraph1);
			document.add(paragraph2);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		document.close();
		List<House> houses = houseService.getAllHouses(1);
		
		//model.addAttribute("houses", houses);
		model.addAttribute("newhouse", new NewHouse());
		model.addAttribute("loggedinuser", getPrincipal());

		return "redirect:osbbadmin";
	}

	@RequestMapping(value = { "/gen" }, method = RequestMethod.POST)
	public String generata(@Valid NewHouse newhouse){
		return "redirect:osbbadmin";
	}

	@RequestMapping(value = { "/reset/{id}" }, method = RequestMethod.GET)
	public HttpStatus resetOwnerCredentials(@PathVariable String id){

		try{
		User old = userService.findById(Integer.parseInt(id));
		Realty r = old.getRealty();
		
		old.setSsoId(r.getHouse().getId()+"_"+r.getHouse().getStreet() + r.getHouse().getNumber() + "_" + Integer.toString(r.getRealtyNumber()));
		
		old.setPassword(new RandomString(20).nextString());
		old.setEmail(null);
		old.setFirstName(null);
		old.setLastName(null);
		userService.updateUser(old);
		System.out.println(old.toString());
		User test = userService.findById(Integer.parseInt(id));
		//test
		}catch(Exception e){
			e.printStackTrace();
		}
		return HttpStatus.OK;
	}
	
	
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
}

class RandomString {

	private static final char[] symbols;

	static {
		StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			tmp.append(ch);
		for (char ch = 'a'; ch <= 'z'; ++ch)
			tmp.append(ch);
		symbols = tmp.toString().toCharArray();
	}

	private final Random random = new Random();

	private final char[] buf;

	public RandomString(int length) {
		if (length < 1)
			throw new IllegalArgumentException("length < 1: " + length);
		buf = new char[length];
	}

	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}
}