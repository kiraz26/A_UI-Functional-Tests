package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BlackList {
	/**
	 * 1. Open Amazon 2. Enter search term Selenium cookbook 3. Verify each result
	 * contains work Selenium
	 */

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Halil\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium cookbook"+Keys.ENTER);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void searchTest() throws InterruptedException{
		//verify every result has the word selenium
		//Algorithm: 
		//1.get the text of all the results
		//write locators that closes 
		//2.store in a list
		//iterate through list
		//verify each element in that list contains selenium
		List<WebElement> allResults=driver.findElements(By.tagName("h2"));
		//findElements -->
		//1.returns a list of web elements, all the elements that match the locators will be returned
		//2.if locators does not match anything, it just returns an empty list, it will not throw the NoSuchElementException
		System.out.println("Number of elements: "+allResults.size());
		
		for(WebElement result : allResults) {
			System.out.println(result.getText());
			Assert.assertTrue(result.getText().toLowerCase().contains("selenium"));
			
		}
		
		
	}
	
	
	
	

}
