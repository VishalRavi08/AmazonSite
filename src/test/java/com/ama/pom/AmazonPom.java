package com.ama.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bas.BaseClass;

public class AmazonPom extends BaseClass{
	
	public AmazonPom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement search;
	
	@FindBy(id = "nav-search-submit-button")
	private WebElement submit;
	
	@FindBy(xpath = "(//span[contains(text(), \"Redmi 12 5G\")])[3]")
	private WebElement product;
	
	@FindBy(id = "buy-now-button")
	private WebElement buyNow;

	public WebElement getSearch() {
		return search;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getBuyNow() {
		return buyNow;
	}
	
	public WebElement getSubmit() {
		return submit;
	}
	

}
