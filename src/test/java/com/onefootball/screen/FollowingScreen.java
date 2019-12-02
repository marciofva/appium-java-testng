package com.onefootball.screen;

import java.util.List;
import com.onefootball.enums.FollowingOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FollowingScreen extends BaseScreen{

	public FollowingScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*actionBtn\")")
	private List<MobileElement>	followingList;
	
	@AndroidFindBy(id = "android:id/parentPanel")
	private MobileElement popup;
	
	@AndroidFindBy(id = "android:id/button2")
	private MobileElement notNowBtn;
	
	public CompetitionScreen goToSection(FollowingOptions followingOptions) {
		checkPopUpForWithoutFavoriteTeam();
		scrollToElementForAndroid(followingOptions.getValue());
		selectByValue(followingList, followingOptions.getValue());
		return new CompetitionScreen(driver);
	}
	
	public void checkPopUpForWithoutFavoriteTeam() {
		if (checkIfElementIsVisibleOrNot(popup)) {
			clickOn(notNowBtn);
		}
	}
}
