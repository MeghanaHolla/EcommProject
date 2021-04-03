package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation {

	@FindBy(css = "#center_column > div > p > strong")
	private WebElement orderConf;
	
	public OrderConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getConfText() {
		return orderConf.getText();
	}
}
