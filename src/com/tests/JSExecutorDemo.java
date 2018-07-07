package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utilities.TestConstants;

public class JSExecutorDemo {
//	@Test
	public void sendJSCommand() {
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		// Using this class we can send javascript commands to the browser
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// .executeScript() --> performs the command
		// The javascript command will be passed as string 
		jsExecutor.executeScript("alert ('WARNING: Cong: You won a GREEN CARD!!!!!!!!');");
	
	
	}
	@Test
	public void scroll() throws InterruptedException {
		System.setProperty(TestConstants.CHROME_DRIVER, TestConstants.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		// Using this class we can send javascript commands to the browser
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		driver.get("https://amazon.com/");
		WebElement element=driver.findElement(By.linkText("Privacy Notice"));
		Thread.sleep(2000);
		// First paramater: javascript code
		// Second paramater: element againist which the js code will be executed
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
		jsExecutor.executeScript("arguments[0].click()", element);
	
	}
}
