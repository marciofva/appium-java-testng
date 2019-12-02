package com.onefootball.dataprovider;

import com.onefootball.enums.Countries;
import com.onefootball.enums.OnboardingSelectTeam;
import com.onefootball.enums.Teams;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.testng.annotations.DataProvider;

public class DataProviderOnboarding {

	@DataProvider(name = "selectTeamAndSelectCountry")
	public Object[][] selectTeamAndSelectCountry() {
		 Map<String, String> map = new HashMap<String, String>();
		 map.put(OnboardingSelectTeam.LOVE_TEAM.getValue(), Teams.MANCHESTER_CITY.getTeamName());
		 map.put(OnboardingSelectTeam.NATIONAL_TEAM.getValue(), Countries.SPAIN.getCountryName());
		return new Object[][] { { map } };
	}
	
	@DataProvider(name = "NoFavoriteTeam")
	public Object[][] NoFavoriteTeam() {
		 Map<String, String> map = new HashMap<String, String>();
		 map.put(OnboardingSelectTeam.LOVE_TEAM.getValue(), Teams.NONE.getTeamName());
		 map.put(OnboardingSelectTeam.NATIONAL_TEAM.getValue(), Countries.FRANCE.getCountryName());
		return new Object[][] { { map } };
	}
	
	@DataProvider(name = "randomNationalTeam")
	public Object[][] randomNationalTeam() {
		 Map<String, String> map = new HashMap<String, String>();
		 map.put(OnboardingSelectTeam.LOVE_TEAM.getValue(), Teams.NONE.getTeamName());
		 map.put(OnboardingSelectTeam.NATIONAL_TEAM.getValue(), getCountry().getCountryName());
		return new Object[][] { { map } };
	}

	private Countries getCountry() {
		return Countries.values()[new Random().nextInt(Countries.values().length)];
	}
}
