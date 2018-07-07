package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utilities.Configuration;
import com.utilities.TestConstants;

public class PropertiesDemo {
	@Test
	public void test() {
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		String url = Configuration.getProperty("url");
		driver.get(url);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(Configuration.getProperty("username"));
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(Configuration.getProperty("password")+Keys.ENTER);
	}
}
