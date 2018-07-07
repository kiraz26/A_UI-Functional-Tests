package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utilities.TestConstants;

public class Sync {

	// @Test
	public void sleep() throws InterruptedException {
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(8000);
		String actual = driver.findElement(By.cssSelector("#finish h4")).getText();
		Assert.assertEquals(actual, "Hello World!");
		driver.quit();

	}

	@Test
	public void implicitWait() {
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		// Only applies to findElement/findElements method
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// waits certain time while the page loading
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// waits certain time while jscripts/processes in the page are executing
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.id("btn")).click();
		Assert.assertTrue(driver.findElement(By.id("message")).isDisplayed());
		System.out.println(driver.findElement(By.id("message")).getText());
		driver.findElement(By.id("btn")).click();

		driver.findElement(By.cssSelector("input#checkbox")).click();

	}
}
