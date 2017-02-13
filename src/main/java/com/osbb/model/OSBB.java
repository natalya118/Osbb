package com.osbb.model;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="OSBBS")
public class OSBB implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotEmpty
	@Column(name="osbb_id", nullable=false)
	private Integer id;
	
	@NotEmpty
	@Column(name="name", nullable=false)
	private String name;
	
	@NotEmpty
	@Column(name="city",nullable=false)
	private String city;
	
	@NotEmpty
	@Column(name="date_created", nullable=false)
	private Double dateCreated;
	
	@NotEmpty
	@Column(name="osbb_code", nullable=false)
	private String osbbCode;
	
	@NotEmpty
	@Column(name="creator_id")
	private String creatorId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Double dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getOsbbCode() {
		return osbbCode;
	}

	public void setOsbbCode(String osbbCode) {
		this.osbbCode = osbbCode;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getMainPersonId() {
		return mainPersonId;
	}

	public void setMainPersonId(String mainPersonId) {
		this.mainPersonId = mainPersonId;
	}

	@NotEmpty
	@Column(name="main_person_id")
	private String mainPersonId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((creatorId == null) ? 0 : creatorId.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mainPersonId == null) ? 0 : mainPersonId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((osbbCode == null) ? 0 : osbbCode.hashCode());
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
		OSBB other = (OSBB) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (creatorId == null) {
			if (other.creatorId != null)
				return false;
		} else if (!creatorId.equals(other.creatorId))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mainPersonId == null) {
			if (other.mainPersonId != null)
				return false;
		} else if (!mainPersonId.equals(other.mainPersonId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (osbbCode == null) {
			if (other.osbbCode != null)
				return false;
		} else if (!osbbCode.equals(other.osbbCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OSBB [id=" + id + ", name=" + name + ", city=" + city + ", dateCreated=" + dateCreated + ", osbbCode="
				+ osbbCode + ", creatorId=" + creatorId + ", mainPersonId=" + mainPersonId + "]";
	}
	


	
}
