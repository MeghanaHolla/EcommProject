package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.*;

import utils.GenericMethods;

public class VerifyAccountCreationTest extends Base {

	@Test
	public void verifyAccountCreation() throws IOException {
		Home hm = new Home(driver);
		Login lp = new Login(driver);
		AccountCreation acc = new AccountCreation(driver);
		MyAccount myAcc = new MyAccount(driver);

		String className = getClass().getTypeName();
		String shortClassName = GenericMethods.getClassName(className);
		String[][] data = GenericMethods.getData("TestData.xlsx",shortClassName);
		String[][] configData = GenericMethods.getData("TestData.xlsx","ConfigurationSheet");
		for(int i = 1; i<data.length; i++) {
			hm.clickSigIn();
			lp.enterEmailAddress(data[i][0]);

			String[] accDetails = data[i];
			acc.createAccount(accDetails);
			GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
			String confirmationText = myAcc.getAccountConfirmationText();
			GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
			Assert.assertEquals(confirmationText, data[i][12]);
			myAcc.clickSignOut();
		}
	}

	

}
