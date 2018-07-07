package com.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.TestConstants;

public class FindCellByIndex {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(TestConstants.WEB_ORDERS_URL);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
	}

	@Test
	public void test() {
		driver.findElement(By.linkText("View all orders")).click();

		// find a cell in a table using the row and column index
		// 8 Rows and 13 Columns
		// 4th row, 5th column --> 02/26/2010
		WebElement row = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[4]/td[5]"));
		String actual = row.getText();
		String expected = "02/26/2010";
		System.out.println("Actual: " + row.getText());
		System.out.println("Expected: " + expected);
		assertTrue(expected.equals(actual));
	}

	@Test
	public void test2() {
		// Find a cell in relation to another cell in the same row
		driver.findElement(By.linkText("View all orders")).click();
		WebElement row = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[11]"));
		String actual = row.getText();
		System.out.println(actual);
		String expected = "770077007700";
		assertTrue(actual.equals(expected));
		// ====================================================================
		// ==============findElement vs. findElements==========================
		// findElement() --> returns a single element if the locator matches
		// --> if the locator does not match, throws an exception
		// --> return type : WebElement
		// findElements() --> returns a LIST of WebElemnts if the locator mathes
		// --> if the locator, still returns an empty list
		// --> return type: List<WebElement>

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
