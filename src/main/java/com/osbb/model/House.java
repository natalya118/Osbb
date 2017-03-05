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
	@Column(name="id", nullable=false)
	private int id;

 
	@NotEmpty
	@Column(name="street", nullable=false)
	private Double street;
	
	@NotEmpty
	@Column(name="number", nullable=false)
	private String number;

	
	@OneToMany(mappedBy="house")
	private Set<Realty> realties;
	
	@Column(name="house_photo")
	private byte[] HousePhoto;
	//May be added
	//private double totalSquare;


	public int getHouseId() {
		return id;
	}


	public void setHouseId(int houseId) {
		id = houseId;
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
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(HousePhoto);
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((realties == null) ? 0 : realties.hashCode());
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
		if (id != other.id)
			return false;
		if (!Arrays.equals(HousePhoto, other.HousePhoto))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (realties == null) {
			if (other.realties != null)
				return false;
		} else if (!realties.equals(other.realties))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
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
