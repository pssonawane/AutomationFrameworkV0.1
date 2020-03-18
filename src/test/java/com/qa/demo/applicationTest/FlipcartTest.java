package com.qa.demo.applicationTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demo.base.TestBase;
import com.qa.demo.commonMethods.FlipcartApp;

public class FlipcartTest extends TestBase{

	FlipcartApp login;
	public static String propertyFile = "flipcart";
	
	@BeforeMethod
	public void setUp() {
		login= new FlipcartApp();
		propertyFileInitialization(propertyFile);
		initilization();
	}
	
	@Test(priority =0)
	public void verifyLoginPageTitle() {
		String title =login.getLogiPageTitlle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority =1)
	public void verifyLoginPageTest() throws Exception {
		String userAccount = login.loggingIn(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertEquals("My Account", userAccount, "Login failed");
	}
	
	@Test(priority =1)
	public void verifyLoginPageTestNegative() throws Exception {
		String userAccount = login.loggingIn(prop.getProperty("Username"), prop.getProperty("PasswordNegative"));
		Assert.assertEquals("My Account", userAccount, "Login failed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
