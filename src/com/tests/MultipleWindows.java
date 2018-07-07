package com.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.BrowserUtils;
import com.utilities.TestConstants;

public class MultipleWindows {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		// open a browser page, one window
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/windows");

	}

	// @Test
	public void test() {
		// returns the window handle for current page
		String handle = driver.getWindowHandle(); // return the handle/id of the current page
		System.out.println(handle);
		driver.findElement(By.linkText("Click Here")).click();
		String newWindowHandle = null;

		Set<String> windowHandles = driver.getWindowHandles();

		// capture the handle of the tab which is not the current tab
		for (String window : windowHandles) {
			System.out.println(window);
			if (!window.equals(handle)) {
				newWindowHandle = window;

			}
		}
		driver.switchTo().window(newWindowHandle);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

	// @Test
	public void switchUsingTitle() {
		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getCurrentUrl());
		String origin = driver.getWindowHandle();
		String targetTitle = "New Window";
		for (String handle : driver.getWindowHandles()) {
			// first switch
			driver.switchTo().window(handle);
			// then check the title
			if (driver.getTitle().equals(targetTitle)) {
				// stop switching
				break;
			}

		}
		System.out.println(driver.getCurrentUrl());

	}

	// @Test
	public void switchUsingUtil() {
		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getCurrentUrl());
		String targetTitle = "New Window";
		BrowserUtils.changeWindow(driver, targetTitle);
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void driverClose() {
		driver.findElement(By.linkText("Click Here")).click();
		driver.findElement(By.linkText("Click Here")).click();
		driver.quit();
		String targetTitle = "New Window";
		BrowserUtils.changeWindow(driver, targetTitle);
		System.out.println(driver.getCurrentUrl());

		// NoSuchSessionException: Session ID is null. Using WebDriver after calling
		// quit()? --> the exception thrown when try to use the same webdriver object
		// after doing the driver.quit() line. we cannot use the same webdriver object after calling quit()
	}

}
