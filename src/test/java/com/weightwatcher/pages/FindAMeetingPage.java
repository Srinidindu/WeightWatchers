package com.weightwatcher.pages;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindAMeetingPage {

	WebDriver driver;
	
	@FindBy(id="meetingSearch")
	private WebElement searchBox;
	
	@FindBy(className="input-group-btn")
	private WebElement searchButton;
	
	@FindBy(className="location__name")
	private List<WebElement> resultTitles;
	
	@FindBy(className="location__distance")
	private List<WebElement> resultDistances;
	
	@FindBy(id="ml-1180510")
	private WebElement firstResult;
	
	@FindBy(className="location__name")
	private WebElement locationName;
	
	@FindBy(className="hours-list-item")
	private List<WebElement> hoursOfOperations;
	
	public FindAMeetingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public FindAMeetingPage findAMeeting(String query) {
		searchBox.sendKeys(query);
		searchButton.click();		
		waitForPageLoad();		
		return new FindAMeetingPage(driver);
	}

	public FindAMeetingPage clickOnFirstResult() {
		firstResult.click();
		waitForPageLoad();
		return new FindAMeetingPage(driver);
	}
	
	public String firstResultTitle() {
		return resultTitles.get(0).getText();
	}
	
	public String firstResultDistance() {
		return resultDistances.get(0).getText();
	}
	
	public String getMeetingLocation() {
		return locationName.getText();
	}
	
	public String getTodaysHoursOfOperations() {
		String today = LocalDate.now().getDayOfWeek().name();
		for(WebElement day: hoursOfOperations) {
			if(day.getText().toUpperCase().contains(today)) {
				return day.getText();
			}
		}
		return null;
	}
	
	public void waitForPageLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
