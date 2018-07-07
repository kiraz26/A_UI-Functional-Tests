package com.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utilities.TestConstants;

public class ExplicitWait {
	// @Test
	public void thisFails() {
		// This method will fail
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();
		// We can find the element but it is not loaded to that page. It is invisible.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.cssSelector("#finish h4"));
		String actual = element.getText();
		System.out.println("TEXT: " + actual);
		Assert.assertEquals(actual, "Hello World!");
	}

	// @Test
	public void waitForVisible() {
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		// locator: By.cssSelector("#finish h4")
		// condition: ExpectedConditions.visibilityOfElementLocated()

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));
		// 1. wait.until()
		// 2. ExpectedConditions.visibilityOfElementLocated()
		// 3. By.cssSelector("#finish h4")
		String actual = element.getText();
		String expected = "Hello World!";
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void waitForDisAppear() {
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.tagName("button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		// Wait fot text 'wait for it' to disappear
		// will wait until element disappears then move on to next line
		Boolean gone = wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[.='Wait for it... ']")));
		assertTrue(gone);
		// message that appears once the checbox disappears
		// will fail since xPath matches the element that is visible on the page
		gone = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));
		assertTrue(gone);
		
		
	}
	
	

}

		