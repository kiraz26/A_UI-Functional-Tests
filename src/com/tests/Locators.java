package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Halil\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.facebook.com/");
//		
		// Find element using id 
//		driver.findElement(By.id("email")).sendKeys("halilkirazz@gmail.com");
//		driver.findElement(By.id("pass")).sendKeys("ASD123asd...");
		
		//Find element using name
//		driver.findElement(By.name("email")).sendKeys("halilkirazz@gmail.com");
//		driver.findElement(By.name("pass")).sendKeys("ASD123asd...");
		
		//LINKS
		//linkText = uses the exact text of the link
//		driver.get("https://www.etsy.com/");
//		driver.findElement(By.linkText("Sell on Etsy")).click();
		
		//partialLinkText = uses the exact text of the link
//		driver.get("https://www.etsy.com/");
//		driver.findElement(By.partialLinkText("on Etsy")).click();
				
		//xPath
		//it starts with one slash and html tag. It shows the whole path in the html tree for the element
		driver.get("https://www.etsy.com/");
		driver.findElement(By.xpath("//*[@id=\"search-query\"]")).sendKeys("wooden spoon");
		driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[2]/button")).click();
		
	
		
	}

}
