package com.weightwatcher.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(id="ela-menu-visitor-desktop-supplementa_find-a-meeting")
	private WebElement findMeetingLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public FindAMeetingPage clickFindOnMeetings() {
		findMeetingLink.click();
		return new FindAMeetingPage(driver);
	}
}
