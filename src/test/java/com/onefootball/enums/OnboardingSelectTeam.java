package com.onefootball.enums;

public enum OnboardingSelectTeam {
	
	LOVE_TEAM("LOVE TEAM"),
	
	NATIONAL_TEAM("NATIONAL TEAM");
	
	private String value;

	OnboardingSelectTeam(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
