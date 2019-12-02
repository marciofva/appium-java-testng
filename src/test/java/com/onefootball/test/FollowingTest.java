package com.onefootball.test;

import java.util.Map;
import java.util.Random;
import org.testng.annotations.Test;
import com.onefootball.dataprovider.DataProviderOnboarding;
import com.onefootball.enums.Competitions;
import com.onefootball.enums.FollowingOptions;
import com.onefootball.enums.MenuNavigationBar;
import com.onefootball.enums.Players;

public class FollowingTest extends BaseTest {
		
	@Test(dataProviderClass = DataProviderOnboarding.class, dataProvider = "selectTeamAndSelectCountry")
	private void searchForCompetition(Map<String, String> map) {
		
		onboarding.onboardingSelectTeam(map)
			.goToFollowingBar(MenuNavigationBar.FOLLOWING)
			.goToSection(FollowingOptions.BROWSE_COMPETITIONS)
			.searchForCompetitionType(getCompetition())
			.isSuccessCompetition();	
	}
	
	@Test(dataProviderClass = DataProviderOnboarding.class, dataProvider = "NoFavoriteTeam")
	private void searchForTeam(Map<String, String> map) {
		
		onboarding.onboardingSelectTeam(map)
			.goToFollowingBar(MenuNavigationBar.FOLLOWING)
			.goToSection(FollowingOptions.BROWSE_TEAMS)
			.searchForTeam(getCompetition())
			.isSuccessTeam();		
	}
	
	@Test(dataProviderClass = DataProviderOnboarding.class, dataProvider = "randomNationalTeam")
	private void searchForPlayer(Map<String, String> map) {
		
		onboarding.onboardingSelectTeam(map)
			.goToFollowingBar(MenuNavigationBar.FOLLOWING)
			.goToSection(FollowingOptions.BROWSE_PLAYERS)
			.searchForPlayer(getPlayer())
			.isSuccessPlayer();		
	}
	
	private Players getPlayer() {
		return Players.values()[new Random().nextInt(Players.values().length)];
	}
	
	private Competitions getCompetition() {
		return Competitions.values()[new Random().nextInt(Competitions.values().length)];
	}
}
