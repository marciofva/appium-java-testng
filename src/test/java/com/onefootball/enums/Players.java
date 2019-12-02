package com.onefootball.enums;

public enum Players {

	CRISTANO_RONALDO("Cristiano Ronaldo"),
	
	NEYMAR("Neymar"),
	
	MESSI("Lionel Messi"),
	
	KYLIAN_MBAPPE("Kylian Mbappe");
	
	private String playerName;

	Players(String playerName){
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return playerName;
	}
}
