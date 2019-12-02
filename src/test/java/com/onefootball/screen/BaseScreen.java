package com.onefootball.screen;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseScreen {
	
	private static final int POLLING_TIMEOUT = 250;
	private static final int MAX_SECONDS_TIMEOUT = 60;
	protected AppiumDriver<MobileElement> driver;
	private FluentWait<WebDriver> wait;
	
	public BaseScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		this.wait =  new FluentWait<WebDriver>(driver).
						withTimeout(Duration.ofSeconds(MAX_SECONDS_TIMEOUT)).
						pollingEvery(Duration.ofMillis(POLLING_TIMEOUT)).
						ignoring(NoSuchElementException.class).
						ignoring(StaleElementReferenceException.class).
						ignoring(IndexOutOfBoundsException.class);
	}
	
	protected void sendValue(MobileElement element, CharSequence value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}
	
	protected void clickOn(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	protected MobileElement waitForElementVisibility(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	protected void scrollToElementForAndroid(String value) {
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ value + "\").instance(0))");
	}
	
	protected void selectByValue(List<MobileElement> list, String value) {
		for(MobileElement element : list) {
			if(element.getText().equalsIgnoreCase(value)) {
				clickOn(element);
				break;
			}
		}
	}
	
	protected boolean isVisible(MobileElement... elements) {
		for (MobileElement element : elements) {
			wait.until(ExpectedConditions.visibilityOf(element));
			if (!element.isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	protected boolean checkIfElementIsVisibleOrNot(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}
