package com.onefootball.enums;

public enum MenuNavigationBar {

	NEWS("News"),
	
	GAMES("Games"),
	
	FOLLOWING("Following"), 
	
	SETTING("Settings");
	
	private String value;

	MenuNavigationBar(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
