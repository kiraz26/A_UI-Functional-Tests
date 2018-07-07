package com.utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrowserUtils {

	public static void verifyCheckBoxSelected(WebElement checkbox) {
		if (checkbox.isSelected()) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void verifyCheckBoxNotSelected(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void verifyPageTitleContains(String actualTitle, String expectedTitle) {
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
			System.out.println("Expected: " + expectedTitle);
			System.out.println("Actual: " + actualTitle);
		}
	}

	public static void verifySearchEntry(String txt) {
		if (txt.equals("charger")) {
			System.out.println("Same");
		} else {
			System.out.println("Different");
			System.out.println("Expected: " + "charger");
			System.out.println("Expected: " + txt);
		}
	}

	// write a method that verifies an element exists
	// method has two params: webdriver, locator
	public static void verifyElementExists(WebDriver driver, By by) {
		try {
			assertTrue(driver.findElement(by).isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.fail("Element was not found");
		}
	}

	public static void verifyTitleMatches(WebDriver driver, String actual, String expected) {
		assertTrue(actual.equals(expected));
	}

	public static void verifyTitleContains(WebDriver driver, String actual, String expected) {
		assertTrue(actual.equals(expected));
	}

	public static void verifyUrlContains(WebDriver driver, String actual, String expected) {
		assertTrue(actual.contains(expected));
	}

	public static void changeWindow(WebDriver driver, String targetTitle) {
		//String origin = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(targetTitle)) {
				return;
			}
		}
		//driver.switchTo().window(origin);
		
	}

}
