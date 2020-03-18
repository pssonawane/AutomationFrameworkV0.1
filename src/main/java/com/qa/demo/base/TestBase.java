package com.qa.demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.demo.util.WebEventListener;


public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static FileInputStream ip;
	public static EventFiringWebDriver e_driver;
	public WebEventListener eventListener;
	public static String userDirectory;

	public void propertyFileInitialization(String propertyFile) {

		userDirectory = System.getProperty("user.dir");

		System.out.println(userDirectory);
		try {
			prop = new Properties();
			ip = new FileInputStream(new File(userDirectory+"\\src\\main\\java\\com\\qa\\demo\\config\\"+propertyFile+".properties"));
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initilization() {

		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("URL");
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",userDirectory+"\\src\\main\\java\\com\\qa\\demo\\config\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.chrome.driver",userDirectory+"\\src\\main\\java\\com\\qa\\demo\\config\\InternetExplorerDriver.exe");
			driver = new InternetExplorerDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
