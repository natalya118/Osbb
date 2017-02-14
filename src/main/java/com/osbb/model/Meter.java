package com.osbb.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="meters")
public class Meter implements Serializable{
	@Id
	@Column(name="meters_id")
	private String metersId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="realty_id")
	private String realtyId;
	
	@Column(name="year")
	private int year;
	
	@Column(name="month")
	private int month;
	
	@Column(name="meters_type_id")
	private String metersTypeId;
	

}
