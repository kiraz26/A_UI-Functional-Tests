package com.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.utilities.TestConstants;

public class FluentWaitDemo {
	@Test
	public void test() {
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();

		// FluentWait
		// customize the Wait by passing paramaters we want. We are using FluentWait to
		// do that
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(5, TimeUnit.SECONDS) // customize the //
																									// timeouts
				.pollingEvery(100, TimeUnit.MILLISECONDS) // control how often selenium will re try the same operation
				.ignoring(NoSuchElementException.class); // pass the exception which will be ignored while trying the
															// same operation
		// import java.util.NoSuchElementException;
		
		//use hte same wait to find the element
		WebElement element= wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("message"));
			}
		});
		assertTrue(element.isDisplayed());
		assertEquals(element.getText(), "It's gone!");
		// import com.google.common.base.Function;

	}
}
