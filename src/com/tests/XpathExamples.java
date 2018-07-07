package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utilities.BrowserUtils;

public class XpathExamples {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Halil\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		//ABSOLUTE XPATH
//		driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();
		
		//RELATIVE XPATH
		//form/input[2]  -->means look any where in the html page.
		
		//verify first is not and second is selected
		WebElement one = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
		WebElement two = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
		System.out.println(one);
		System.out.println(two);
		if(one.isSelected()) {
			System.out.println("Checkbox 1 is selected");
		}else {
			System.out.println("Checkbox 1 is not selected");
		}
		if(two.isSelected()) {
			System.out.println("Checkbox 2 is selected");
		}else {
			System.out.println("Checkbox 2 is not selected");
		}
		
		//select checkbox 1
		one.click();
		BrowserUtils.verifyCheckBoxSelected(one);
		//unselect checkbox 2
		two.click();
		BrowserUtils.verifyCheckBoxNotSelected(two);
		
		
		Thread.sleep(5000);
		driver.close();

	}

}
