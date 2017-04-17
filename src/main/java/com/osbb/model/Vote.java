package com.osbb.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@IdClass(VoteId.class)
public class Vote {
	@Id
	private int userId;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "variantId", insertable = false, updatable = false)
	private Variant variant;
	//private int variantId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Variant getVariant() {
		return variant;
	}
	public void setVariant(Variant variant) {
		this.variant = variant;
	}



}
