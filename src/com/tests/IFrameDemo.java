package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.TestConstants;

public class IFrameDemo {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/iframe");

	}

//	@Test
	public void test() {
		// 1. We have to find the iFrame
		// 2. Call driver.switchTo().frame() by passing the iFrame element
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("ZALIM ZALIM ZALIM ZALIM NE OLACAK BENIM HALIM!!");
		driver.switchTo().parentFrame(); // goes to the parent
		// driver.switchTo().defaultContent(); //goes to the first parent
		System.out.println(driver.findElement(By.linkText("Elemental Selenium")));

	}
	
//	@Test
	public void test2() {
		// We can also switch to iframes by passing the name or id directly
		driver.switchTo().frame("mce_0_ifr"); // id
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("ZALIM ZALIM ZALIM ZALIM NE OLACAK BENIM HALIM!!");
		driver.switchTo().parentFrame(); // goes to the parent
		// driver.switchTo().defaultContent(); //goes to the first parent
		System.out.println(driver.findElement(By.linkText("Elemental Selenium")));
	}
	
	@Test
	public void test3() {
		// Switch by count
		driver.switchTo().frame(0); // number
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("ZALIM ZALIM ZALIM ZALIM NE OLACAK BENIM HALIM!!");
		driver.switchTo().parentFrame(); // goes to the parent
		// driver.switchTo().defaultContent(); //goes to the first parent
		System.out.println(driver.findElement(By.linkText("Elemental Selenium")));
	}
}
