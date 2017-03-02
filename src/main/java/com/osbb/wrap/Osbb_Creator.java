package com.osbb.wrap;

import com.osbb.model.Osbb;
import com.osbb.model.User;

public class Osbb_Creator {
	public final User creator;
	public final Osbb osbb;
	
	public Osbb_Creator(){
		this.creator = new User();
		this.osbb = new Osbb();
	}

	public Osbb_Creator(User creator, Osbb osbb) {
		this.creator = creator;
		this.osbb = osbb;
	}

	public User getCreator() {
		return creator;
	}

	public Osbb getOsbb() {
		return osbb;
	}
	

}
