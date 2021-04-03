package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformation {
	
	@FindBy(css = "#new_comment_tab_btn > span")
	private WebElement addReview;
	
	@FindBy(css="#criterions_list > li > div.star_content > div:nth-child(6) > a")
	private WebElement rating;
	
	@FindBy(id="comment_title")
	private WebElement title;
	
	@FindBy(id="content")
	private WebElement reviewComment;
	
	@FindBy(id="submitNewMessage")
	private WebElement submitReview;
	
	@FindBy(css = "#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened > div > div > div > p:nth-child(2)")
	private WebElement reviewConfirmation;
	
	@FindBy(css = "#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened > div > div > div > p.submit > button")
	private WebElement okButton;
	
	@FindBy(css = "#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > p.socialsharing_product.list-inline.no-print > button.btn.btn-default.btn-facebook")
	private WebElement shareOnFB;
	
	@FindBy(name="Submit")
	private WebElement addToCart;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
	private WebElement proceedToCheckOut;
	
	public ProductInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart() {
		addToCart.click();
		proceedToCheckOut.click();
	}
	
	public String addReviewComment(String reviewTitle, String comments) {
		addReview.click();
		rating.click();
		title.sendKeys(reviewTitle);
		reviewComment.sendKeys(comments);
		submitReview.click();
		String confText = reviewConfirmation.getText();
		okButton.click();
		return confText;
	}

	public void shareOnFB() {
		shareOnFB.click();
	}
}
