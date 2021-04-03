package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.ProductInformation;

import utils.GenericMethods;

public class VerifyAddReviewsTest extends Base {
	
	@Test
	public void verifySubmitReview() throws IOException, InterruptedException {
		Home hm = new Home(driver);
		Login lp = new Login(driver);
		AccountCreation acc = new AccountCreation(driver);
		MyAccount myAcc = new MyAccount(driver);
		ProductInformation productInfo = new ProductInformation(driver);

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
			
			 myAcc.selectProduct(driver);
			String reviewConfText =  productInfo.addReviewComment(data[i][13], data[i][14]);
			Assert.assertEquals(reviewConfText, data[i][15]);
			GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
			try {
				myAcc.clickSignOut();
			}
			catch(Exception ex) {
				GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
				Assert.fail("Sign out link not present");
			}
		}
	}

}
