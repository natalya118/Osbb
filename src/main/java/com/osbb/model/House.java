package com.osbb.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Houses")
public class House implements Serializable{

	//@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@NotEmpty
	@Column(name="house_id", nullable=false)
	private String HouseId;

	@NotEmpty
	@Column(name="city", nullable=false)
	private String city;
 
	@NotEmpty
	@Column(name="street", nullable=false)
	private Double street;
	
	@NotEmpty
	@Column(name="number", nullable=false)
	private String number;

	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "osbb_id", nullable = false)
//	private Osbb osbb;
	
	@OneToMany(mappedBy="house")
	private Set<Realty> realties;
	
	@Column(name="house_photo")
	private byte[] HousePhoto;
	//May be added
	//private double totalSquare;


	public String getHouseId() {
		return HouseId;
	}


	public void setHouseId(String houseId) {
		HouseId = houseId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Double getStreet() {
		return street;
	}


	public void setStreet(Double street) {
		this.street = street;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public byte[] getHousePhoto() {
		return HousePhoto;
	}


	public void setHousePhoto(byte[] housePhoto) {
		HousePhoto = housePhoto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((HouseId == null) ? 0 : HouseId.hashCode());
		result = prime * result + Arrays.hashCode(HousePhoto);
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if (HouseId == null) {
			if (other.HouseId != null)
				return false;
		} else if (!HouseId.equals(other.HouseId))
			return false;
		if (!Arrays.equals(HousePhoto, other.HousePhoto))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "House [HouseId=" + HouseId + ", city=" + city + ", street=" + street + ", number=" + number
				+ ", HousePhoto=" + Arrays.toString(HousePhoto) + "]";
	}
	
//	@NotEmpty
//	@ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class)
//	@JoinTable(name = "APP_USER_DISCIPLINE", 
//             joinColumns = { @JoinColumn(name = "STUDENT_ID") }, 
//             inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
//	private Set<User> students;
//
//	//private Set<UserProfile> userProfiles = new HashSet<UserProfile>();	
//	
//	public Set<User> getStudents()  
//    {  
//        return students;  
//    }  
//    public void setStudents(Set<User> students)  
//    {  
//        this.students = students;  
//    }  

}
