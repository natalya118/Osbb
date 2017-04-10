package com.osbb.wrap;

public class NewHouse {
	public String street;

	public String number;

	public String flatsFrom;
	
	public String flatsTo;
	
	public NewHouse(){}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFlatsFrom() {
		return flatsFrom;
	}

	public void setFlatsFrom(String flatsFrom) {
		this.flatsFrom = flatsFrom;
	}

	public String getFlatsTo() {
		return flatsTo;
	}

	public void setFlatsTo(String flatsTo) {
		this.flatsTo = flatsTo;
	}

	@Override
	public String toString() {
		return "NewHouse [street=" + street + ", number=" + number + ", flatsFrom=" + flatsFrom + ", flatsTo=" + flatsTo
				+ "]";
	}
	
	

	


	
	
}
