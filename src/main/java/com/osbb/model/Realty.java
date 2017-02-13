package com.osbb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="realties")
public class Realty {
	
	@Id
	@Column(name="realty_id")
	private String realtyId;
	
	@NotNull
	@Column(name="realty_house_id")
	private String realtyHouseId;
	
	@NotNull
	@Column(name="realty_owner_id")
	private String realtyOwnerId;
	
	@NotNull
	@Column(name="realty_number_or_desc", length=40)
	private String realtyNumberOrDesc;

	public String getRealtyId() {
		return realtyId;
	}

	public void setRealtyId(String realtyId) {
		this.realtyId = realtyId;
	}

	public String getRealtyHouseId() {
		return realtyHouseId;
	}

	public void setRealtyHouseId(String realtyHouseId) {
		this.realtyHouseId = realtyHouseId;
	}

	public String getRealtyOwnerId() {
		return realtyOwnerId;
	}

	public void setRealtyOwnerId(String realtyOwnerId) {
		this.realtyOwnerId = realtyOwnerId;
	}

	public String getRealtyNumberOrDesc() {
		return realtyNumberOrDesc;
	}

	public void setRealtyNumberOrDesc(String realtyNumberOrDesc) {
		this.realtyNumberOrDesc = realtyNumberOrDesc;
	}

	@Override
	public String toString() {
		return "Realty [realtyId=" + realtyId + ", realtyHouseId=" + realtyHouseId + ", realtyOwnerId=" + realtyOwnerId
				+ ", realtyNumberOrDesc=" + realtyNumberOrDesc + "]";
	}
	
	
}
