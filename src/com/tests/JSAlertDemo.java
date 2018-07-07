package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.TestConstants;

public class JSAlertDemo {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// @Test
	public void alertAcceptTest() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button)[1]")).click();
		Thread.sleep(2000);
		// Capture the alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		// Click on the alert
		alert.accept();

	}

	// @Test
	public void alertCancelTest() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button)[2]")).click();
		Thread.sleep(2000);
		// Capture the alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		// Click on the alert
		alert.dismiss();

	}

//	@Test
	public void alertTypeTest() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("(//button)[3]")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Kapat sunu Muhittin Abi");
		alert.accept();
	}
	@Test
	public void test() {
		//start testing
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		//continue testing
	}
}
