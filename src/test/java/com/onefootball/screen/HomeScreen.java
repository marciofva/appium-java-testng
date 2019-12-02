package com.onefootball.screen;

import java.util.List;
import com.onefootball.enums.MenuNavigationBar;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen {

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*fixed_bottom_navigation_title\")")
	private List<MobileElement>	bottomNavigationBarOptions;
	
	public FollowingScreen goToFollowingBar(MenuNavigationBar menuOption) {
		selectByValue(bottomNavigationBarOptions, menuOption.getValue());
		return new FollowingScreen(driver);
	}
}
