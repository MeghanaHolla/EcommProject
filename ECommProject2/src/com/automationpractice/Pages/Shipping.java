package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping {

	@FindBy(id="cgv")
	private WebElement agreeTAndC;
	

	@FindBy(name = "processCarrier")
	private WebElement proceed;
	
	public Shipping(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ProceedToCheckOut() {
		agreeTAndC.click();
		proceed.click();
	}
}
