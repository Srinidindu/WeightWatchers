package com.weightwatcher.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.weightwatcher.pages.FindAMeetingPage;
import com.weightwatcher.pages.HomePage;

public class MeetingFinderTest{

	private WebDriver driver;
	
	private  WebDriver getDriver(String appURL) {
		System.out.println("Launching Chrome browser..");
		System.setProperty("webdriver.chrome.driver","/Users/veera.suravaram/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browser", "app" })
	@BeforeClass
	public void setUp(String browser, String url) {
		driver = getDriver(url);
	}
	
	@Test
	public void verifyFirstMeetingLocation() {
		HomePage home = new HomePage(driver);
		Assert.assertEquals("Weight Loss Program, Recipes & Help | Weight Watchers", home.getPageTitle());
		FindAMeetingPage findMeetingsPage= home.clickFindOnMeetings();
		Assert.assertTrue(findMeetingsPage.getPageTitle().contains("Get Schedules & Times Near You"));
		findMeetingsPage.findAMeeting("10011");
		String firstResultTitle = findMeetingsPage.firstResultTitle();
		System.out.println("first result  title " + firstResultTitle);
		System.out.println("first result  distance " + findMeetingsPage.firstResultDistance());
		findMeetingsPage.clickOnFirstResult();
		Assert.assertEquals(firstResultTitle, findMeetingsPage.getMeetingLocation());
		System.out.println("Todays hours of operation " + findMeetingsPage.getTodaysHoursOfOperations());
		
	}
}
