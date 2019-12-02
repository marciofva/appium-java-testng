package com.onefootball.enums;

public enum FollowingOptions {

	BROWSE_TEAMS("BROWSE TEAMS"), 
	
	BROWSE_COMPETITIONS("BROWSE COMPETITIONS"),
	
	BROWSE_PLAYERS("BROWSE PLAYERS");
	
	private String value;

	FollowingOptions(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
