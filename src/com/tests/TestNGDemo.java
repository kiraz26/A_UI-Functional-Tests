package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Always runs once before any test");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Always runs once after any test");
	}
	
	@Test
	public void firstTest() {
		System.out.println("Running First Test");
	}
	
	@Test //annotation is the most important part 
	public void secondTest() {
		System.out.println("Running Second Test");
	}
	
	
	
}
