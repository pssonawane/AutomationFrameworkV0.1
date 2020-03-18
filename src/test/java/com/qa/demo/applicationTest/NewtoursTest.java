package com.qa.demo.applicationTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.demo.base.TestBase;
import com.qa.demo.commonMethods.NewtoursApp;
import com.qa.demo.testData.ReadDataFromExcel;

public class NewtoursTest extends TestBase{

	NewtoursApp login;
	public static String propertyFile = "newtour";
	
	@BeforeMethod
	public void setUp() {
		login= new NewtoursApp();
		propertyFileInitialization(propertyFile);
		initilization();
	}
	
	@Test(priority =0)
	public void verifyLoginPageTitle() {
		String title =login.getLogiPageTitlle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}
	
	@Test(priority =1)
	public void verifyLoginPageTest() {
		login.loggingIn(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@DataProvider
	public static Object[][] getdataFromExcelProvider(){
		Object object[][]=ReadDataFromExcel.getdataFromExcel();
		return object;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
