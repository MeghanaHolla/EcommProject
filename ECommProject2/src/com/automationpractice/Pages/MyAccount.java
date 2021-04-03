package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
	@FindBy(css= "#center_column > p")
    private WebElement accountCreationSuccess;
	
	@FindBy(partialLinkText = "Sign out")
	private WebElement signOut;
	
	@FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
	private WebElement tShirts;
	
	@FindBy(css="#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")
	private WebElement selectShirt;
	
	@FindBy(css="#center_column > ul > li > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default > span")
	private WebElement moreBtn;
	
	
	public void  selectProduct(WebDriver driver) {
		tShirts.click();
		Actions hover = new Actions(driver);
		hover.moveToElement(selectShirt).perform();
		moreBtn.click();
		
	}
	
	public void openProduct(WebDriver driver) {
		tShirts.click();
		Actions hover = new Actions(driver);
		hover.moveToElement(selectShirt).perform();
		moreBtn.click();
	}
	public MyAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getAccountConfirmationText() {
		return accountCreationSuccess.getText();
	}
	
	public void clickSignOut() {
		signOut.click();
	}
}


