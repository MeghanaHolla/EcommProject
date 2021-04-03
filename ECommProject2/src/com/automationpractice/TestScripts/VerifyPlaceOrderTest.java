package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.AddressConfirmation;
import com.automationpractice.Pages.Cart;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.OrderConfirmation;
import com.automationpractice.Pages.Payment;
import com.automationpractice.Pages.ProductInformation;
import com.automationpractice.Pages.Shipping;

import utils.GenericMethods;

public class VerifyPlaceOrderTest extends Base{
	
	@Test
	public void verifyPlaceOrder() throws IOException {
		Home hm = new Home(driver);
		Login lp = new Login(driver);
		AccountCreation acc = new AccountCreation(driver);
		MyAccount myAcc = new MyAccount(driver);
		ProductInformation info = new ProductInformation(driver);
		Cart cart = new Cart(driver);
		AddressConfirmation conf = new AddressConfirmation(driver);
		Shipping shp = new Shipping(driver);
		Payment ptm = new Payment(driver);
		OrderConfirmation orderConf = new OrderConfirmation(driver);

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
			
			info.addToCart();
			
			cart.clickProceedToCheckOut();
			conf.clickToProceed();
			shp.ProceedToCheckOut();
			ptm.completeMyOrder();
		
			String getOrderConfirmation = orderConf.getConfText();
			
			Assert.assertEquals(getOrderConfirmation, data[i][13]);
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
