package com.onefootball.enums;

public enum Teams {
	
	NONE("None"),
	
	MANCHESTER_CITY("Manchester City"), 
	
	LIVERPOOL("Liverpool"),
	
	FARENSE("Farense"),
	
	FLUMINENSE("Fluminense");
	
	private String team;

	Teams(String team){
		this.team = team;
	}
	
	public String getTeamName() {
		return team;
	}
}
