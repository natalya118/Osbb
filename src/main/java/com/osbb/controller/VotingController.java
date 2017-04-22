package com.osbb.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
import com.osbb.model.Realty;
import com.osbb.model.Variant;
import com.osbb.model.Vote;
import com.osbb.model.Voting;
import com.osbb.model.chats.Chat;
import com.osbb.service.ChatService;
import com.osbb.service.MessageService;
import com.osbb.service.NewsService;
import com.osbb.service.UserProfileService;
import com.osbb.service.UserService;
import com.osbb.service.VariantService;
import com.osbb.service.VoteService;
import com.osbb.service.VotingService;
import com.osbb.wrap.Chat_Users;
import com.osbb.wrap.NewVoting;

@Controller
@SessionAttributes("roles")
@RequestMapping("/votings")
public class VotingController {
	@Autowired
	UserService userService;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	VotingService votingService;
	
	@Autowired
	VariantService variantService;
	
	@Autowired
	VoteService voteService;
	
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
	public String listVotings(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("newVoting", new NewVoting());
		votingService.completelyLiked(2);
		List<Voting> allVotings = votingService.getAllVotingsByOsbbId(userService.findBySSO(getPrincipal()).getOsbbId());
		for(Voting v: allVotings){
			v.setVoted(votingService.voted(userService.findBySSO(getPrincipal()).getId(), v.getId()));
			for(Variant var: v.getVariants()){
				System.out.println("-------------------------------");
				System.out.println(var.getId());
				System.out.println(votingService.countPercent(var));
				var.setPercent(votingService.countPercent(var));
		
			}
		}
				//System.out.println(votingService.numberOfVotedUsers(2));
	
		model.addAttribute("allvotings", allVotings);
		return "votings";
	}

	@RequestMapping(value = { "/newvoting" }, method = RequestMethod.POST)
	public String addNews(@Valid NewVoting newVoting, BindingResult result, ModelMap model) {
		Voting voting = new Voting();

		voting.setOsbbId(userService.findBySSO(getPrincipal()).getOsbbId());
		voting.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		voting.setTopic(newVoting.getTopic());
		voting.setDescription(newVoting.getDescription());
		
		List<Variant> variants = new ArrayList<Variant>();
		
		
		if(newVoting.getV1().length()>0){
			Variant v = new Variant();
			v.setVariant(newVoting.getV1());
			//v.setVoting(voting);
			variants.add(v);
		}
		
		if(newVoting.getV2().length()>0){
			Variant v2 = new Variant();
			v2.setVariant(newVoting.getV2());
			//v2.setVoting(voting);
			System.out.println("V2===" +newVoting.getV2());
			variants.add(v2);
		}
		if(newVoting.getV3().length()>0){
			Variant v3 = new Variant();
			v3.setVariant(newVoting.getV3());
			//v3.setVoting(voting);
			variants.add(v3);
		}
		if(newVoting.getV4().length()>0){
			Variant v4 = new Variant();
			v4.setVariant(newVoting.getV4());
			//v4.setVoting(voting);
			variants.add(v4);
		}
		if(newVoting.getV5().length()>0){
			Variant v5 = new Variant();
			v5.setVariant(newVoting.getV5());
			//v5.setVoting(voting);
			variants.add(v5);
		}
		Collections.sort(variants,new Comparator<Variant>() {
	         @Override
	        public int compare(Variant v1,  Variant v2) {
	                return Integer.compare(v1.getId(), v2.getId());
	        }
	    });
		Set<Variant> variantss = new HashSet<Variant>(variants);
		voting.setVariants(variantss);
		votingService.saveVoting(voting);
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/votings/all";
	}
	
	@RequestMapping(value = { "/vote/{id}" }, method = RequestMethod.GET)
	public String vote(@PathVariable String id){
		Vote vote = new Vote();
		vote.setUserId(userService.findBySSO(getPrincipal()).getId());
		Variant var = variantService.getVariantById(Integer.parseInt(id));
		vote.setVariant(var);
		voteService.saveVote(vote);
		return "redirect:/votings/all";
	}
	@RequestMapping(value = { "remove/{id}" }, method = RequestMethod.GET)
	public String removeVoting(@PathVariable String id){
		votingService.deleteVoting(Integer.parseInt(id));
		return "redirect:/votings/all";
	}


}
