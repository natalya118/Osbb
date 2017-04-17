package com.osbb.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Variant implements Comparable {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@NotNull
	private String variant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voting_id")
	private Voting voting;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "variant")
	private Set<Vote> votes; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public Voting getVoting() {
		return voting;
	}

	public void setVoting(Voting voting) {
		this.voting = voting;
	}

	@Override
	public String toString() {
		return "Variant [id=" + id + ", variant=" + variant + ", voting=" + voting + "]";
	}

	@Override
	public int compareTo(Object v2) {
		if (this.id > ((Variant) v2).id)
			return 1;
		else
			return 0;
	}


}
