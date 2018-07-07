package com.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;
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

public class WebOrdersTables {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		// maximing a webpage
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(TestConstants.WEB_ORDERS_URL);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
	}

	@Test
	public void test() {
		//get the number of rows before
		driver.findElement(By.linkText("View all orders")).click();
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
		int rowNumber = allRows.size();
		// place an order
		driver.findElement(By.linkText("Order")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("1");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Micheal");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("470 Schrock Rd");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Columbus");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("OHIO");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("43229");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4444444444444444");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("06/22");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

		assertTrue(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"))
				.isDisplayed());
		// come back to orders page and get the row count and compare
		driver.findElement(By.linkText("View all orders")).click();
		List<WebElement> allRowsAfter = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
		int rowNumberAfter = allRowsAfter.size();
		
		assertTrue(rowNumber<rowNumberAfter);
		
		for (WebElement allRowAfter : allRowsAfter) {
			System.out.println(allRowAfter.getText());
			
		}
	
		
	}

	 @AfterMethod
	 public void tearDown() {
	 driver.quit();
	 }
}
