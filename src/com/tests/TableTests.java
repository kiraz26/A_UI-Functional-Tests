package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.TestConstants;

public class TableTests {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		//maximing a webpage
		//driver.manage().window().maximize();
		driver.get(TestConstants.WEB_ORDERS_URL);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" +Keys.ENTER);
	}
	
	@Test
	public void test() {
		driver.findElement(By.linkText("View all products")).click();
		//PRINT THE WHOLE TABLE
		WebElement table = driver.findElement(By.xpath("//table[@class='ProductsTable']"));
		System.out.println(table.getText());
		// PRINT THE NAMES OF THE COLUMNS
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@class='ProductsTable']//th"));
		for (WebElement columnName : columnNames) {
			System.out.println(columnName.getText());
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr"));
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}
		
		int numberOFColumns = columnNames.size();
		int numberOfRows = rows.size();
		System.out.println("My table has "+numberOFColumns+" columns and "+numberOfRows+" rows.");
		//CTRL+1
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
