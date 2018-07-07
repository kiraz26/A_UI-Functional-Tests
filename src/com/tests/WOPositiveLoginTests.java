package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.BrowserUtils;
import com.utilities.TestConstants;

public class WOPositiveLoginTests {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(
				"http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fWebOrders%2fDefault.aspx");
	}

	@Test
	public void test() {
		String expectedTitle = "Web Orders Login";
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), expectedTitle);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), "Web Orders");
		String expectedUrl = "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";
		BrowserUtils.verifyUrlContains(driver, driver.getCurrentUrl(), expectedUrl);

	}

}
