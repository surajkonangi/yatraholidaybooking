package com.atmecs.yatra.validation;

import java.io.IOException;

import org.openqa.selenium.By;

import com.atmecs.yatra.constants.LogReports;
import com.atmecs.yatra.testbase.TestBase;
import com.atmecs.yatra.utils.Readproperties;

public class ValidationResult extends TestBase {
	static String actualtourPackage;
	static String actualdepart;
	static String actualgoTo;
	static String actualmonthofTravel;
	static String actualprice;
	static String actualday1plan;
	static String actualday2plan;
	static String actualday3plan;
	static String actualday4plan;
	static String actualday5plan;
	static String expectedPackage = "Best Of Bali - Lembongan Island Cruise";
	static String expecteddepart = "Hyderabad";
	static String expectedgoTo = "Bali";
	static String expectedmonthofTravel = "OCT 2019";
	static String expectedPrice = "Rs.41,000";
	static String expectedday1plan="Arrival";
	static String expectedday2plan="Day 2 - Uluwatu and Beach Full Day Tour";
	static String expectedday3plan="Day 3 - Nusa Lembongan Full Day Cruise by Bali Hai";
	static String expectedday4plan="Day 4 - Ubud and Kintamani Full Day Tour";
	static String expectedday5plan="Day 5 - Departure";

	public static void placeValidate() throws IOException, InterruptedException {
		Readproperties read = new Readproperties();
		LogReports log = new LogReports();
		
		actualtourPackage = driver.findElement(By.xpath(read.readPropertiesFile("bookpage.packageverification.txt"))).getText();
		ValidateTestResult.validateData(actualtourPackage, expectedPackage, "validating tour");
		log.info("package name validated....");
		actualdepart = driver.findElement(By.xpath(read.readPropertiesFile("validate.Departure.txt"))).getAttribute("value");
		ValidateTestResult.validateData(actualdepart, expecteddepart, "validating departure");
		log.info("Depatured place validated...");
		actualgoTo = driver.findElement(By.xpath(read.readPropertiesFile("validate.goto.txt"))).getAttribute("value");
		ValidateTestResult.validateData(actualgoTo, expectedgoTo, "validatingGoTo");
		log.info("goto place validated....");
		actualmonthofTravel = driver.findElement(By.xpath(read.readPropertiesFile("validate.mothoftravel.txt"))).getAttribute("value");
		ValidateTestResult.validateData(actualmonthofTravel, expectedmonthofTravel, "validatingmonthoftravel");
		log.info("monthoftravel validated...");
		actualprice = driver.findElement(By.xpath(read.readPropertiesFile("validating.price.txt"))).getText();
		ValidateTestResult.validateData(actualprice, expectedPrice, "validating price");
        log.info("price validated....");
        actualday1plan=driver.findElement(By.xpath(read.readPropertiesFile("validating.firstday.txt"))).getText();
        ValidateTestResult.validateData(actualday1plan, expectedday1plan, "validating day1 plan");
        log.info("day1plan validated...");
        actualday2plan=driver.findElement(By.xpath(read.readPropertiesFile("validating.secondday.txt"))).getText();
        ValidateTestResult.validateData(actualday2plan, expectedday2plan, "validating day2 plan");
        log.info("day2plan validated...");
        actualday3plan=driver.findElement(By.xpath(read.readPropertiesFile("validating.thirdday.txt"))).getText();
        ValidateTestResult.validateData(actualday3plan, expectedday3plan, "validating day3 plan");
        log.info("day3plan validated...");
        actualday4plan=driver.findElement(By.xpath(read.readPropertiesFile("validating.forthday.txt"))).getText();
        ValidateTestResult.validateData(actualday4plan, expectedday4plan, "validating day4 plan");
        log.info("day4plan validated...");
        actualday5plan=driver.findElement(By.xpath(read.readPropertiesFile("validating.fifthday.txt"))).getText();
        ValidateTestResult.validateData(actualday5plan, expectedday5plan, "validating day5 plan");
        log.info("day5plan validated...");
        
        
        
         driver.quit();
	}
	
}
