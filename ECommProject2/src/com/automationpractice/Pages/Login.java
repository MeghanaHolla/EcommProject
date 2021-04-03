package com.automationpractice.Pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(id="email_create")
	private WebElement emailAddress;
	
	@FindBy(id="SubmitCreate")
	private WebElement createAcc;
	
	@FindBy(id="email")
	private WebElement loginEmail;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement signIn;
	
	@FindBy(css="#center_column > div.alert.alert-danger > ol > li")
	private WebElement loginError;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getLoginErrorMessage() {
		return loginError.getText();
	}
	public void logintoApplication(String loginID, String loginPassword) {
		loginEmail.sendKeys(loginID);
		password.sendKeys(loginPassword);
		signIn.click();
	}
	
	
	public void enterEmailAddress(String emailID) {
		String[] splitEmail = emailID.split("@");
		
		emailID = splitEmail[0] +new Random().nextInt()+"@"+splitEmail[1];
		emailAddress.sendKeys(emailID);
		createAcc.click();
	}

}
