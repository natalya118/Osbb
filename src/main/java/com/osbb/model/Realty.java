package com.osbb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "realties")
public class Realty implements Comparable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column
	private int realtyOwnerId;

	@NotNull
	@Column
	private int realtyNumber;

	@ManyToOne
	@JoinColumn(name = "house_id")
	private House house;

	@OneToOne
	@JoinColumn(name = "owner_id")
	private User owner;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRealtyOwnerId() {
		return realtyOwnerId;
	}

	public void setRealtyOwnerId(int realtyOwnerId) {
		this.realtyOwnerId = realtyOwnerId;
	}

	public int getRealtyNumber() {
		return realtyNumber;
	}

	public void setRealtyNumber(int realtyNumber) {
		this.realtyNumber = realtyNumber;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	@Override
	public String toString() {
		return "Realty [d=" + id + ", realtyOwnerId=" + realtyOwnerId + ", realtyNumber=" + realtyNumber + ", house="
				+ house + "]";
	}

	@Override
	public int compareTo(Object r2) {
		if (this.getId() > ((Realty) r2).getId())
			return 1;
		else
			return 0;
	}

}
