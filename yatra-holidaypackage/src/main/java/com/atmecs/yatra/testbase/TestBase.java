package com.atmecs.yatra.testbase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.atmecs.yatra.constants.ConstantPaths;
import com.atmecs.yatra.constants.LogReports;
import com.atmecs.yatra.utils.Readproperties;

public class TestBase {

	public WebDriver driver;
	LogReports log = new LogReports();
	String url;

	@BeforeTest
	public void invokeBrowser()throws IOException {

		String base =Readproperties.readConfig("Browser");
	    url = Readproperties.readConfig("Url");

		if (base.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
			driver = new ChromeDriver();
			log.info("Chrome browser started...");
			
		}

		else if (base.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ConstantPaths.FIREFOX_FILE);
			driver = new FirefoxDriver();
			log.info("Firefox browser started...");

		}

		else if (base.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
			driver = new InternetExplorerDriver();
			log.info("IE browser started...");
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Application is open...");
	}
}
