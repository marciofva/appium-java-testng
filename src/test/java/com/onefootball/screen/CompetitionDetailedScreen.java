package com.onefootball.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CompetitionDetailedScreen extends BaseScreen {

	public CompetitionDetailedScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = "toolbar_title")
	private MobileElement title;
	
	@AndroidFindBy(id = "spinner_label")
	private MobileElement spinnerLabel;
	
	public String getTitle() {
		return title.getText();
	}
	
	public boolean isSuccessCompetition() {
		return isVisible(title, spinnerLabel);
	}
}
