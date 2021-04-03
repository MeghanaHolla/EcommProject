package com.automationpractice.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AccountCreation {

	@FindBy(id="id_gender2")
	private WebElement female;
	
	@FindBy(id="id_gender1")
	private WebElement male;
	
	@FindBy(id="customer_firstname")
	private WebElement fName;
	
	@FindBy(id="customer_lastname")
	private WebElement lName;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="firstname")
	private WebElement addressFirstName;
	
	@FindBy(id="lastname")
	private WebElement addressLastName;
	
	@FindBy(id="address1")
	private WebElement addressLine1;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="id_state")
	private WebElement stateDD;
	
	@FindBy(id="postcode")
	private WebElement zipCode;
	
	@FindBy(id="id_country")
	private WebElement country;
	
	@FindBy(id="phone_mobile")
	private WebElement mobile;
	
	@FindBy(id="alias")
	private WebElement aliasEmail;
	
	@FindBy(id="submitAccount")
	private WebElement register;
	
	@FindBy(css="#center_column > div")
	private WebElement errorAlert;
	
	public AccountCreation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getErrorMessage() {
		String getErrorMessage = errorAlert.getText();
		return getErrorMessage;
	}
	
	public void selectCoutry() {
		Select countryDropDown = new Select(country);
		countryDropDown.selectByIndex(1);
		Select stateDropDown = new Select(stateDD);
		stateDropDown.selectByIndex(1);
		register.click();
	}
	
	public void createAccount(String[] accDetails) {
		if(accDetails[1].equals("Female")) {
			female.click();
		}
		else {
			male.click();
		}
		fName.sendKeys(accDetails[2]);
		lName.sendKeys(accDetails[3]);
		
		password.sendKeys(accDetails[4]);
		
		//addressFirstName.sendKeys(accDetails[4]);
		//addressLastName.sendKeys(accDetails[5]);
		
		addressLine1.sendKeys(accDetails[5]);
		
		city.sendKeys(accDetails[6]);
		Select stateDropDown = new Select(stateDD);
		stateDropDown.selectByVisibleText(accDetails[7]);
		
		zipCode.sendKeys(accDetails[8]);
		
		Select countryDropDown = new Select(country);
		countryDropDown.selectByVisibleText(accDetails[9]);
		
		mobile.sendKeys(accDetails[10]);
		aliasEmail.clear();
		aliasEmail.sendKeys(accDetails[11]);
		
		register.click();
	}
	
}
