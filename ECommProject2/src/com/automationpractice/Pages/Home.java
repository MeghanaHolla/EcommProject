package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	@FindBy(css="#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement signIn;
	
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSigIn() {
		signIn.click();
	}
	
	public boolean isSignInPresent () {
		return  signIn.isDisplayed();
	}
}
