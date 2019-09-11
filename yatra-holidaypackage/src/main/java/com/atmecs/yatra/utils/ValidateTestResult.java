package com.atmecs.yatra.utils;

import org.testng.Assert;

public class ValidateTestResult {

	public boolean validateData(Object actual, Object expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
			return true;
		} catch (AssertionError assertionError) {
			return false;
		}
	}
}