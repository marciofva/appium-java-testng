package com.onefootball.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.onefootball.factory.DriverFactory;
import com.onefootball.screen.OnboardingScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {
	
	public static AppiumDriver<MobileElement> driver;
	protected OnboardingScreen onboarding;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "platform", "device" })
	public void setup(String platform, String device) {
		driver = DriverFactory.getInstance(platform, device);
		onboarding = new OnboardingScreen(driver);
	}
		
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
