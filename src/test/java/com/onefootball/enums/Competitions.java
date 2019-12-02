package com.onefootball.enums;

public enum Competitions {
	
	/***
	 * The parameters mean:
	 * 1: Team or International Competition
	 * 2: Competition
	 * 3: Team Member
	 */

	INTERNATIONAL_2018_19("2018-19 International", "UEFA Nations League", "France"), 
	
	INTERNATIONAL_CLUBS_2018_19("2018-19 International - Clubs", "Europa League", "FC Porto"),
	
	BRAZIL("Brazil", "Copa do Brasil", "Botafogo"),
	
	BELGIUM("Belgium", "Division 1A", "Mechelen"),
	
	GERMANY_BAYERN("Germany", "Regionalliga Bayern", "Bayreuth"),
	
	GERMANY_LIGA("Germany", "3. Liga", "Chemnitzer FC"),
	
	ITALY("Italy", "Coppa Italia", "Catanzaro"),
	
	ENGLAND("England",  "Premier League", "Liverpool");
	
	private String competitionType;
	private String competitionName;
	private String associateTeam;
	
	Competitions(String competitionType, String competitionName, String associateTeam){
		this.competitionType = competitionType;
		this.competitionName = competitionName;
		this.associateTeam = associateTeam;
	}

	public String getCompetitionType() {
		return competitionType;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public String getAssociateTeam() {
		return associateTeam;
	}
}
