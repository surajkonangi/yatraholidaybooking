package com.atmecs.yatra.validation;

import org.testng.Assert;

import com.atmecs.yatra.constants.LogReports;
import com.atmecs.yatra.testbase.TestBase;
import com.atmecs.yatra.utils.Readproperties;

public class ValidateTestResult extends TestBase {
	static LogReports log = new LogReports();
	Readproperties read = new Readproperties();

	public static  boolean validateData(String actual,String expected, String message) {
		try {
			/*
			 * 
			 * print actual and expected value
			 * 
			*/
			Assert.assertEquals(actual, expected);
			
			return true;
		} catch (AssertionError assertionError) {
			
			return false;
		}
	}
}
