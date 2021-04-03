package com.automationpractice.TestScripts;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.Facebook;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.ProductInformation;

import utils.GenericMethods;

public class ShareProjectTest extends Base{
	
	@Test
	public void shareProduct() throws IOException {
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
			
			myAcc.selectProduct(driver);
			
			ProductInformation info = new ProductInformation(driver);
			info.shareOnFB();
			//***********Code to switch to other window *******************
			Set<String> wndHandles = driver.getWindowHandles();
			Object[] converToArray = wndHandles.toArray();
			driver.switchTo().window(converToArray[1].toString());
			
			
			Facebook fb = new Facebook(driver);
			boolean fbPageOpen = fb.isFBPageOpen();
			
			GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
			Assert.assertTrue(fbPageOpen);
			driver.close();
			driver.switchTo().window(converToArray[0].toString());
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
