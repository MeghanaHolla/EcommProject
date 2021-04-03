package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {

	@FindBy(css="#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	private WebElement payByBankWire;
	
	@FindBy(css="#cart_navigation > button")
	private WebElement completeOrder;
	
	public Payment(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void completeMyOrder() {
		payByBankWire.click();
		completeOrder.click();
	}
}
