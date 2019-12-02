package com.onefootball.enums;

public enum Countries {

	SPAIN("Spain"),
	
	BRAZIL("Brazil"),
	
	ITALY("Italy"),
	
	FRANCE("France"),
	
	POLAND("Poland"),
	
	CHILE("Chile"),
	
	ENGLAND("England");
	
	private String country;

	Countries(String country){
		this.country = country;
	}
	
	public String getCountryName() {
		return country;
	}
}
