package com.onefootball.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TeamScreen extends BaseScreen {

	public TeamScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = "header_name")
	private MobileElement headerTeamName;
	
	@AndroidFindBy(id = "follow_button")
	private MobileElement followBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*indicator\")")
	private MobileElement teamMenu;
			
	public boolean isSuccessTeam() {
		return isVisible(headerTeamName, followBtn, teamMenu);
	}
}
