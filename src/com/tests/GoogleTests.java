package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTests {
	// SCENARIO
	// Test Case 1
	// Open browser
	// Go to Google.com
	// search for charger
	// verify title equals "charger - Google Search"

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Halil\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		// .close --> only closes the current tab,if you have more tabs, they will stay
		// open, it does not make the object null
		// .quit --> closes the browser with all tabs, make the object null;
	}

	@Test
	public void searchTest() {

		// Keys --> this class from Selenium gives us options for pressing keys from
		// keyboard
		// if we want to hit enter --> Keys.ENTER
		// Escape --> Keys.ESCAPE
		// Keys.ENTER needs to be passed to the sendKeys method
		driver.findElement(By.id("lst-ib")).sendKeys("charger" + Keys.ENTER);

		String actual = driver.getTitle();
		String expected = "charger - Google Search";

		Assert.assertEquals(actual, expected);
	}

	// Test Case 2
	// Open browser
	// Go to Google.com
	// search for car
	// verify title equals "car - Google Search"

	@Test
	public void searchTestTwo() {

		// Keys --> this class from Selenium gives us options for pressing keys from
		// keyboard
		// if we want to hit enter --> Keys.ENTER
		// Escape --> Keys.ESCAPE
		// Keys.ENTER needs to be passed to the sendKeys method
		driver.findElement(By.id("lst-ib")).sendKeys("car" + Keys.ENTER);

		String actual = driver.getTitle();
		String expected = "car - Google Search";

		Assert.assertEquals(actual, expected);
	}

}
