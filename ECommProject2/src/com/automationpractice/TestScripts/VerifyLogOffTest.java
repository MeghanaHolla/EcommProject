package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;

import utils.GenericMethods;

public class VerifyLogOffTest extends Base {


	@Test
	public void verifyLogOff() throws IOException, InterruptedException {
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

			String confirmationText = myAcc.getAccountConfirmationText();
			Assert.assertEquals(confirmationText, data[i][12]);
			try {
				myAcc.clickSignOut();
				GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
				boolean signOffSuccessful = hm.isSignInPresent();
				Assert.assertTrue(signOffSuccessful);
			}
			catch(Exception ex) {
				GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
				Assert.fail("Sign out link not present");
			}
		}
	}
}
