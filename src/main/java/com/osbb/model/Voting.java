package com.osbb.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Transactional
public class Voting {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column 
	@NotNull
	private String topic;
	
	@Column(length=400)
	private String description;
	
	@Column
	private Timestamp createdDate;
	
	@Column
	private int osbbId;
	
	@Column
	private boolean isOpenNow;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "voting", cascade = CascadeType.REMOVE)
	private Set<Variant> variants; 
	
	private boolean voted;
	
	
	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp timestamp) {
		this.createdDate = timestamp;
	}

	public Set<Variant> getVariants() {
		return variants;
	}

	public void setVariants(Set<Variant> variants) {
		this.variants = variants;
	}

	public int getOsbbId() {
		return osbbId;
	}

	public void setOsbbId(int osbbId) {
		this.osbbId = osbbId;
	}

	public boolean isOpenNow() {
		return isOpenNow;
	}

	public void setOpenNow(boolean isOpenNow) {
		this.isOpenNow = isOpenNow;
	}

	@Override
	public String toString() {
		return "Voting [id=" + id + ", topic=" + topic + ", description=" + description + ", createdDate=" + createdDate
				+ ", osbbId=" + osbbId + ", isOpenNow=" + isOpenNow + ", variants=" + variants + "]";
	}

	


	
	
	

}
