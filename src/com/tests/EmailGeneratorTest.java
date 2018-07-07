package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utilities.EmailGenerator;

public class EmailGeneratorTest {
	
	@Test
	public void domainTest() {
		String actual = EmailGenerator.generate("talhaerturk");
		String company = "cybertek.com";
		//we are waiting for true we run actual.endsWith(company)
		System.out.println(actual.endsWith(company));
		//assertTrue ---> expect 
		Assert.assertTrue(actual.endsWith(company));
		
		System.out.println("Done"); // if test fails, it will not be executed.
		
	}
	
	@Test
	public void emailMatchesTest() {
		String actual = EmailGenerator.generate("talhaerturk");
		String expected = "talhaerturk@cybertek.com";
		
		Assert.assertEquals(actual, expected);
	}
	
	
}
