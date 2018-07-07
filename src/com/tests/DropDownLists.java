package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownLists {
	/**
	 * TC 3: Search results verifications 1. Open
	 * https://the-internet.herokuapp.com/dropdown 2. Enter search term Selenium
	 * cookbook 3. Verify default Ship to option is United States 4. Verify options
	 * contain Canada 5. Select Canada 6. Verify Ship to option is now Canada
	 */

	// DropDown Lists
	// dropdown are represented by tag called select most of the time.
	// selenium uses the element with select tag to work with dropdown
	// operations we can do on dropdown:
	// 1.see whats selected
	// 2.see what are the options
	// 3.make selection

	// In order to work with dropdown we need to create new object of the type
	// Select BY using the select tag. we can create select object by passing an
	// element with select tag as a constructor
	// In order to be able to create a select object, we must pass an element with
	// select tag

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Halil\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		// To create a Select object
		// 1. find the element with a select tag
		WebElement element = driver.findElement(By.id("dropdown"));
		// 2. create the Select object by passing the element as a constructor
		Select list = new Select(element);
		// getFirstSelectedOption() --> returns the option that is select
		// getAllSelectedOption() --> returns all the options which are slected(some
		// dropdown lists allow multiple //selection)
		// print the currently selected option
		System.out.println("First selected option: " + list.getFirstSelectedOption().getText());
		// print all of the options
		// getOptions() --> returns all the options
		List<WebElement> allOptions = list.getOptions();
		System.out.println(allOptions.size());
		for (WebElement webElement : allOptions) {
			System.out.println(webElement.getText());
		}
		// selectByVisibleText() --> selects option based on the text displayed, takes a
		// String parameter
		System.out.println("Selecting Option 1");
		list.selectByVisibleText("Option 1");
		System.out.println(list.getFirstSelectedOption().getText());

		System.out.println("Selecting Option 2");
		list.selectByVisibleText("Option 2");
		System.out.println(list.getFirstSelectedOption().getText());

		// selectByIndex() --> select options based on the count, takes an int parameter
		System.out.println("Selecting first one");
		list.selectByIndex(1);
		System.out.println(list.getFirstSelectedOption().getText());

		System.out.println("Selecting second one");
		list.selectByIndex(2);
		System.out.println(list.getFirstSelectedOption().getText());

		// selectByValue() --> selects option based on the value of the value attribute
		// of the option, takes a String parameter
		System.out.println("Selecting value one");
		list.selectByValue("1");
		System.out.println(list.getFirstSelectedOption().getText());

		System.out.println("Selecting value two");
		list.selectByValue("2");
		System.out.println(list.getFirstSelectedOption().getText());

		// WHAT IF THERE IS NO SELECT TAG
		// 1. you have to label for the dropdown separately as a webelement. The label
		// shows whats selected. is also shows the options when we click on it. If we
		// want to select we have to find the label and click on it to be able to open
		// the list
		// 2. Locate the option you want to select separately.perform select operation
		// by doing the click() method on the option you want to select. So just click.
		
		
		
		

	}
	
	//
	
	
}
