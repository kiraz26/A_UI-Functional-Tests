package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.BrowserUtils;
import com.utilities.TestConstants;

public class WONegativeTests {
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
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Test");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), expectedTitle);
		BrowserUtils.verifyUrlContains(driver, driver.getCurrentUrl(), currentUrl);

	}

	@Test
	public void test2() {
		String expectedTitle = "Web Orders Login";
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), expectedTitle);
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), expectedTitle);
		BrowserUtils.verifyUrlContains(driver, driver.getCurrentUrl(), currentUrl);

	}

	@Test
	public void test3() {
		String expectedTitle = "Web Orders Login";
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), expectedTitle);
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), expectedTitle);
		BrowserUtils.verifyUrlContains(driver, driver.getCurrentUrl(), currentUrl);

	}

	@Test
	public void test4() {
		String expectedTitle = "Web Orders Login";
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), expectedTitle);
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		BrowserUtils.verifyTitleMatches(driver, driver.getTitle(), expectedTitle);
		BrowserUtils.verifyUrlContains(driver, driver.getCurrentUrl(), currentUrl);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
