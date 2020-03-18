package com.qa.demo.commonMethods;

import org.openqa.selenium.By;

import com.qa.demo.base.TestBase;

public class NewtoursApp extends TestBase{

	public String getLogiPageTitlle() {
		return driver.getTitle();
	}

	public void loggingIn(String user, String pass) {
		driver.findElement(By.name(prop.getProperty("locatorName_username"))).sendKeys(user);
		driver.findElement(By.name(prop.getProperty("locatorName_password"))).sendKeys(pass);
		driver.findElement(By.name(prop.getProperty("locatorName_loginbutton"))).click();
	}	
	
	public void selectValueFromTable(String time1,String time2) {	
		driver.findElement(By.xpath("//*[@class='data_center_mono']//*[contains(text(),'"+time1+"')]/parent::td/preceding-sibling::td[@class='frame_action_xrows']")).click();
		driver.findElement(By.xpath("//*[@class='data_center_mono']//*[contains(text(),'"+time2+"')]/parent::td/preceding-sibling::td[@class='frame_action_xrows']")).click();
	}	
}
