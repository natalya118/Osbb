package com.osbb.model.companies;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Companies")

public class Company implements Serializable{

	@Id
	@Column(name="company_id")
	private String companyId;
	
	@NotNull
	@Column(name="company_name",length=120)
	private String companyName;
	
	@NotNull
	@Column(name="date_added")
	private Date dateAdded;
	
	@Column(name="description",length=500)
	private String description;
	
	@Column(name="logo")
	private byte[] logo;

	
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", dateAdded=" + dateAdded
				+ ", description=" + description + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
