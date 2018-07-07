package com.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertSoftly {

	@Test
	public void test() {
		// SoftAssert--> is a class provided by testing, provides assertation methods
		// which will not stop the execution is any of them fail
		// When softAssert class is used, assertion method do not run immedietly
		// assertAll() --> this method will actually run the assertions and report.
		// This method has to be called when soft assertations are used
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Before Test");
		softAssert.assertEquals(3, 2);
		System.out.println("After Test");
		softAssert.assertAll();
	}

	@Test
	public void test2() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(true);
		softAssert.assertTrue(false);

		softAssert.assertEquals(1, 1);
		softAssert.assertEquals(1, 2);

		softAssert.assertNotEquals(1, 1);
		softAssert.assertNotEquals(1, 2);

		softAssert.assertAll();
	}

	// End to End Testing --> testing a certain flow of the functionality form
	// beginning to end. Single application will have multiple end to end flows.

}
