package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressConfirmation {
	
	@FindBy(name = "processAddress")
	private WebElement proceedToCheckOut;
	
	public AddressConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickToProceed() {
		proceedToCheckOut.click();
	}

}
