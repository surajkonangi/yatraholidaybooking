package com.atmecs.yatra.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.yatra.constants.PageAction;
import com.atmecs.yatra.testbase.TestBase;
import com.atmecs.yatra.utils.Readproperties;
import com.atmecs.yatra.utils.TestDataProvider;
import com.atmecs.yatra.utils.ValidateTestResult;

public class testscritp extends TestBase {

	@Test(dataProvider = "destination", dataProviderClass = TestDataProvider.class)

	public void openTable(String[] values) throws IOException, InterruptedException {
		Readproperties read = new Readproperties();
		PageAction page = new PageAction();
		ValidateTestResult validate = new ValidateTestResult();

		page.clickOnElement(driver, read.readPropertiesFile("holiday.searchpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("departfromclick.searchpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("departfrom.searchpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("goingtoclick.searchpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("goingto.searchpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("monthoftraveldropdown.searchpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("monthoftravel.searchpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("searchholiday.searchpage.txt"));
		// page.clickOnElement(driver,read.readPropertiesFile("closewrapper.selectpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("pricedecreasingorder.selectpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("pricedecreasingorder.selectpage.txt"));
		page.clickOnElement(driver, read.readPropertiesFile("viewdetails.selectpage.btn"));

		String name = driver.findElement(By.xpath("(//h2[text()='Best Of Bali - Lembongan Island Cruise'])[2]")).getText();
		assertEquals(name, "Best Of Bali - Lembongan Island Cruise");
	//validate.validateData("Nischal", "Suraj", "passed");
	//Assert.assertEquals("Nischal", "Suraj");
	
	}

}