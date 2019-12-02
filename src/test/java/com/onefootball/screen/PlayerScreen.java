package com.onefootball.screen;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PlayerScreen extends BaseScreen {

	public PlayerScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = "header_name")
	private MobileElement headerPlayerName;
	
	@AndroidFindBy(id = "follow_button")
	private MobileElement followBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*indicator\")")
	private MobileElement playerMenu;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView")
	private List<MobileElement>	menuOptions;
	
    List<String> expectedMenuOptions = new ArrayList<String>( Arrays.asList("INFO", "SEASON")); 
    
    private static final String MESSAGE = "Players screen has an invalid Menu";
	
	public boolean isSuccessPlayer() {
		validateMenuOptions();
		return isVisible(headerPlayerName, followBtn, playerMenu);
	}
	
	public void validateMenuOptions() {
		waitForElementVisibility(playerMenu);
		assertEquals(menuOptions.size(), expectedMenuOptions.size(), MESSAGE);
	}
}
