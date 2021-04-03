package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;


import utils.GenericMethods;

public class VerifyCountryFieldBlankZipCodeInvalidTest extends Base{
	
	@Test
	
	public void verifyCountryFieldLeftBlank() throws IOException {
		Home hm = new Home(driver);
		Login lp = new Login(driver);
		AccountCreation acc = new AccountCreation(driver);
		

		String className = getClass().getTypeName();
		String shortClassName = GenericMethods.getClassName(className);
		System.out.println(shortClassName);
		String[][] data = GenericMethods.getData("TestData.xlsx",shortClassName);
		String[][] configData = GenericMethods.getData("TestData.xlsx","ConfigurationSheet");
		for(int i = 1; i<data.length; i++) {
			hm.clickSigIn();
			lp.enterEmailAddress(data[i][0]);
			acc.createAccount(data[i]);
			String countryError = acc.getErrorMessage();
			if(countryError.contains(data[i][12])) {
				GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
				Assert.assertTrue(true,"Correct Error Message is displayed when country is left Blank");
			}
			else {
				GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
				Assert.fail("No Error Message displyed when country is left blank");
			}
			acc.selectCoutry();
			String zipError = acc.getErrorMessage();
			if(zipError.contains(data[i][13])) {
				GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
				Assert.assertTrue( true,"Correct Error Message is displayed when Zip code less than 5 digits is entered");
			}
			else {
				GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
				Assert.fail("No Error Message displyed when zip code less than 5 digits is entered");
			}
			
		}
	}

}
