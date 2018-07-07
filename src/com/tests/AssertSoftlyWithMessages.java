package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertSoftlyWithMessages {

	SoftAssert soft = new SoftAssert();

	// @BeforeMethod
	// public void setUp() {
	// soft = new SoftAssert();
	// }

	// all assertation methods are overloaded and they can take extra string
	// parameter, but only if it fail, message will be written
	@Test
	public void test1() {
		soft.assertTrue(true, "should probably pass and be ignored");
		soft.assertTrue(false, "expected true but it was false. Why??");
		// soft.assertAll();
	}

	@Test
	public void test2() {
		soft.assertNotNull(soft, "did not expect null here");
		soft.assertNotNull(null, "it was null\n");
		soft.assertAll();
		// this line will not be included in assertAll report, becuse it comes after
		// assertAll() is called
		soft.assertTrue(false, "expected true but it was false. Why??");
	}

	/*
	 * TestNG report will show that first method passed, second failed that is
	 * because of assertAll being in the second method. But it did capture failures
	 * from both methods as it shows in the console
	 */

}
