package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

	@FindBy(css="#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
	private WebElement proceedToCheckOut;
	
	
	public Cart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickProceedToCheckOut() {
		proceedToCheckOut.click();
	}
}
