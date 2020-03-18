package com.qa.demo.commonMethods;

import org.openqa.selenium.By;

import com.qa.demo.base.TestBase;

public class FlipcartApp extends TestBase{

	public String getLogiPageTitlle() {
		return driver.getTitle();
	}

	public String loggingIn(String user, String pass) throws InterruptedException {
		//driver.findElement(By.name(prop.getProperty("locatorClass_login"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("locatorXpath_username"))).sendKeys(user);
		driver.findElement(By.xpath(prop.getProperty("locatorXpath_password"))).sendKeys(pass);
		driver.findElement(By.xpath(prop.getProperty("locatorXpath_loginbutton"))).click();
		Thread.sleep(2000);
		String userAccount = driver.findElement(By.xpath(prop.getProperty("locatorXpath_myAccount"))).getText();
		return userAccount;
	}	
	
}
