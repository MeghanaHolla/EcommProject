package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;


import utils.GenericMethods;

public class VerifyInvalidLoginTest extends Base{
	
	@Test
	public void verifyInvaliLogin() throws IOException {
		Home hm = new Home(driver);
		Login lp = new Login(driver);
		
		String className = getClass().getTypeName();
		String shortClassName = GenericMethods.getClassName(className);
		String[][] data = GenericMethods.getData("TestData.xlsx",shortClassName);
		String[][] configData = GenericMethods.getData("TestData.xlsx","ConfigurationSheet");
		for(int i = 1; i<data.length; i++) {
			hm.clickSigIn();
			lp.logintoApplication(data[i][0], data[i][1]);
			String errorMessage = lp.getLoginErrorMessage();
			if(errorMessage.contains(data[i][2])) {
				Assert.assertTrue(true, "Error message displayed when invalid credetials are entered");
				GenericMethods.takeScreenshot(configData[1][2], driver,shortClassName);
			}
			else {
				Assert.fail("No Error Message displayed when invalid credentails are entered");
			}
		}
	}

}
