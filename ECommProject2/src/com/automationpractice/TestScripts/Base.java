package com.automationpractice.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.GenericMethods;


public class Base {
	
	WebDriver  driver; 
	@BeforeTest
	@Parameters("browser")

	public void openApplication(String browser) throws IOException {
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		String[][] data = GenericMethods.getData("TestData.xlsx","ConfigurationSheet");
		long timeOut = Long.parseLong(data[1][1]);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		
		driver.get(data[1][0]);
	}

	@AfterTest
	public void closeApplication() {
		driver.close();
	}
}
