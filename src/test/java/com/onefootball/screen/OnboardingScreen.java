package com.onefootball.screen;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingScreen extends BaseScreen{

	public OnboardingScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*following_item_name\")")
	private List<MobileElement> teamList;
	
	@AndroidFindBy(id = "onboarding_title_text")
	private MobileElement onboardingTitleLbl;
	
	@AndroidFindBy(id = "onboarding_cta")
	private MobileElement noTeamBtn;
	
	@AndroidFindBy(id = "confirmTxt")
	private MobileElement agreementConfirmationBtn;
	
	private static final String NO_FAVORITE_TEAM =  "None";
	
	public OnboardingScreen clickOnhaveNoTeamBtn() {
		clickOn(noTeamBtn);
		return this;
	}
	
	public OnboardingScreen agreementConfirmation() {
		clickOn(agreementConfirmationBtn);
		return this;
	}
	
	public OnboardingScreen selectTeam(String teamName) {
		scrollToElementForAndroid(teamName);
		selectByValue(teamList, teamName);
		return this;
	}
	
	public HomeScreen onboardingSelectTeam(Map<String, String> map) {
		
						
		for (Entry<String, String> entry : map.entrySet()) {
			waitForElementVisibility(onboardingTitleLbl);
			if (entry.getValue().equalsIgnoreCase(NO_FAVORITE_TEAM)) {
				clickOnhaveNoTeamBtn();
			}else {
				selectTeam(entry.getValue());
			}
		}
		agreementConfirmation();
		return new HomeScreen(driver);
	}
}
