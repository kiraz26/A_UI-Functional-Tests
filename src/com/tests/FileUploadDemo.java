package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.TestConstants;

public class FileUploadDemo {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void fileUploadTest() {
		driver.get("https://the-internet.herokuapp.com/upload");
		String file = "C:\\\\Users\\\\Halil\\\\Desktop\\\\New Text Document.txt";
		driver.findElement(By.id("file-upload")).sendKeys(file);
		
		driver.findElement(By.id("submit")).click();
		

	}
}
