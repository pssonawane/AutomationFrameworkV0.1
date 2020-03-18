package com.qa.demo.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.qa.demo.base.TestBase;

public class TestUtil extends TestBase{

	public static long Page_Load_Timeout = 20;
	public static long Implicitly_Wait = 10;
	public static ITestResult result;
	
	//Drop-down value
	public void selectDropdown(WebElement locator, String value) {
		Select select = new Select(locator);
		select.selectByVisibleText(value);
	}
	
	//Radio value
	public void selectRadio(List<WebElement> locator,String exvalue) {
		for(WebElement temp : locator) {
			if(temp.getAttribute("value").equalsIgnoreCase(exvalue)) {
				temp.click();
			}
		}
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String methodName = result.getName();
		FileUtils.copyFile(scrFile, new File(userDirectory + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	
}
