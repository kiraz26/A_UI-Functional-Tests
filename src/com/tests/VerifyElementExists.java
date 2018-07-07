package com.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/login.aspx
 * login
 * after logging in, verify that login button is no more visible
 */
public class VerifyElementExists {
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
		//1. save the element when is it available on the page, before logging in,
		//then do whatever you wanna do 
		//2. look for by id
		//3. save the element when is it available on the page, before logging in,
		//compare it with all the elements in the page, obviously he is talking about
		//buttons, not all elements
		//4. hidden attribute
		//5. No Such Element
		
//		WebElement el = driver.findElement(By.id("ctl00_MainContent_login_button"));
//		assertTrue(el.isDisplayed());
		
//		assertFalse(
//				driver.findElement( // find element runs before assertion
//						By.id("ctl00_MainContent_login_button")).
//							isDisplayed());
		
		try {
			// try to find it
			//if I find it, it is bad news
			//test fails
			WebElement el = driver.findElement(By.id("ctl00_MainContent_login_button"));
			Assert.assertFalse(el.isDisplayed());
		}
		// catch will only happen if we cannot find element
		catch (NoSuchElementException e) {
			// test passed
			assertTrue(true);
		}
		
	
		
		
	}
	
	
}
