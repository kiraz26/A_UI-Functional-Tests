package com.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.BrowserUtils;

/*
 * go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/login.aspx
 * login
 * verify that Welcome, Tester! | Logout message is Displayed
 * log out
 * verify that Welcome, Tester! | Logout message is Displayed
 * 
 */
public class VerifyElementExistsAgain {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Halil\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/login.aspx");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

//		try {
//			assertTrue(driver.findElement(By.className("login_info")).isDisplayed());
//		} catch (NoSuchElementException e) {
//			// Assert.fail() --> when this line is called, the test will fail.. this method
//			// is used the fail the test on purpose
//			Assert.fail("Welcome message was not found");
//		}
		
		BrowserUtils.verifyElementExists(driver, By.className("login_info"));
		
		System.out.println("this line will print");

		driver.findElement(By.id("ctl00_logout")).click();

		try {
			assertFalse(driver.findElement(By.className("login_info")).isDisplayed(),
					"Welcome message should not be displayed");
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found");
			
		}

	}
}
