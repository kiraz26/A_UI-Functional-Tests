package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utilities.BrowserUtils;

public class TestCaseOne {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Halil\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.etsy.com/");
		driver.findElement(By.id("search-query")).sendKeys("charger");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Charger";

		BrowserUtils.verifyPageTitleContains(actualTitle, expectedTitle);

		// getting the text from element
		String txt = driver.findElement(By.id("search-query")).getAttribute("value");
		System.out.println("value: " + txt);
		// Verify search entry
		BrowserUtils.verifySearchEntry(txt);

		txt = driver.findElement(By.id("search-query")).getAttribute("id");
		System.out.println("id: " + txt);

		txt = driver.findElement(By.id("search-query")).getAttribute("name");
		System.out.println("name: " + txt);

		txt = driver.findElement(By.id("search-query")).getAttribute("class");
		System.out.println("class: " + txt);

	}

	

}
