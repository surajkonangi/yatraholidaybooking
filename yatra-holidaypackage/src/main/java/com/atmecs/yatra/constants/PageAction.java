package com.atmecs.yatra.constants;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PageAction {
	static WebDriver driver;

	public static void selectDropdown(String xpath, String visibleText) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Select noOfpeople = new Select(element);
		noOfpeople.selectByVisibleText(visibleText);

	}

	public void clickOnElement(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}

	public void sendKeys(WebDriver driver, String xpath, String value) {
		WebElement a=driver.findElement(By.xpath(xpath));
		//.sendKeys(value);
		Actions action=new Actions(driver);
		a.sendKeys(value);
		a.sendKeys(Keys.ENTER);
		//action.sendKeys(Keys.ENTER).build().perform();

	
	}
	
	
	public static void ClickElement(WebDriver driver, final String xpath) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS).ignoring(ElementNotInteractableException.class);
		wait.until(new Function<WebDriver, Boolean>()
		{
			public Boolean apply(WebDriver driver)
			{
				driver.findElement(By.xpath(xpath)).click();
				return true;
}
		});
	}
}