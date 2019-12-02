package com.onefootball.screen;

import java.util.List;
import java.util.logging.Logger;
import com.onefootball.enums.Competitions;
import com.onefootball.enums.Players;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CompetitionScreen extends BaseScreen {

	public CompetitionScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*item_name\")")
	private List<MobileElement>	competitionTypeList;
	
	@AndroidFindBy(id = "section")
	private MobileElement CompetitionSection;
	
	@AndroidFindBy(id = "search_src_text")
	private MobileElement searchInputText;
	
	public CompetitionDetailedScreen searchForCompetitionType(Competitions competition) {
		searchFor(competition.getCompetitionType());
		searchFor(competition.getCompetitionName());
		return new CompetitionDetailedScreen(driver);
	}
	
	public TeamScreen searchForTeam(Competitions competition) {
		searchFor(competition.getCompetitionType());
		searchFor(competition.getCompetitionName());
		searchFor(competition.getAssociateTeam());
		return new TeamScreen(driver);
	}
	
	public PlayerScreen searchForPlayer(Players players) {
		sendValue(searchInputText, players.getPlayerName());
		searchFor(players.getPlayerName());
		return new PlayerScreen(driver);
	}
	
	public void searchFor(String value) {
		Logger.getGlobal().info("\n>>>> Searching for: < ".concat(value) + " >\n");
		scrollToElementForAndroid(value);
		selectByValue(competitionTypeList, value);
	}
}
