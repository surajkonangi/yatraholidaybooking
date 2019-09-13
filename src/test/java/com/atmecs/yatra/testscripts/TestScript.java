package com.atmecs.yatra.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.atmecs.yatra.constants.LogReports;
import com.atmecs.yatra.constants.PageAction;
import com.atmecs.yatra.testbase.TestBase;
import com.atmecs.yatra.utils.Readproperties;
import com.atmecs.yatra.utils.TestDataProvider;
import com.atmecs.yatra.validation.ValidationResult;

public class TestScript extends TestBase {

	@Test(dataProvider = "destination", dataProviderClass = TestDataProvider.class)

	public void HolidayPackage(String[] values) throws IOException, InterruptedException {
		Readproperties read = new Readproperties();
		PageAction page = new PageAction();
		LogReports log = new LogReports();
		//to select on (holidays) option for the menu
		page.clickOnElement(driver, read.readPropertiesFile("searchpage.holiday.txt"));
		//to click on depart from 
		page.clickOnElement(driver, read.readPropertiesFile("searchpage.departfromclick.txt"));
		// to enter the city from where we depart(hyderabad)
		page.clickOnElement(driver, read.readPropertiesFile("searchpage.departfrom.txt"));
		//to click on goto
		page.clickOnElement(driver, read.readPropertiesFile("searchpage.goingtoclick.txt"));
		//to enter the city name that we are going to(Bali)
		page.clickOnElement(driver, read.readPropertiesFile("searchpage.goingto.txt"));
		//clicking on month of travel option
		page.clickOnElement(driver, read.readPropertiesFile("searchpage.monthoftraveldropdown.txt"));
		//to select month of travel option(October 2019)
		page.clickOnElement(driver, read.readPropertiesFile("searchpage.monthoftravel.txt"));
		//clicking to search button
		page.clickOnElement(driver, read.readPropertiesFile("searchpage.searchholiday.txt"));
		//clicking on the price to filter packages in  ascending order
		page.clickOnElement(driver, read.readPropertiesFile("selectpage.pricedecreasingorder.txt"));
		//clicking on the price again to filter it in descending order 
		page.clickOnElement(driver, read.readPropertiesFile("selectpage.pricedecreasingorder.txt"));
		log.info("sorted the price successfully..");
		//clicking on the required package(Best of Bali) 
		page.clickOnElement(driver, read.readPropertiesFile("selectpage.viewdetails.btn"));
		log.info("selected the required holidaypackage... ");
		ValidationResult.placeValidate();

	}

}
