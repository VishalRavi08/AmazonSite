package com.ama.stepdefinition;

import java.util.Iterator;
import java.util.Set;

import com.ama.pom.AmazonPom;
import com.bas.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonStepdefinition extends BaseClass {

	AmazonPom a;

	@Given("user Launches The Browser")
	public void user_Launches_The_Browser() {
		launchBrowser();
	}

	@When("user Enters The Url")
	public void user_Enters_The_Url() {
		launchUrl("https://www.amazon.in/");
//		launchUrl("https://www.flipkart.com/");
		maximize();
	}

	@Then("user Searches For The Product")
	public void user_Searches_For_The_Product() {
//		redmi 12 5g
		a = new AmazonPom();
		sendValues(a.getSearch(), "redmi 12 5g");
		clickOnElement(a.getSubmit());
	}

	@Then("user Selects The Product")
	public void user_Selects_The_Product() {
		a = new AmazonPom();
		clickOnElement(a.getProduct());
	}

	@Then("user Buys The Product")
	public void user_Buys_The_Product() throws InterruptedException {

		String parentId = driver.getWindowHandle();
		System.out.println("Parent ID: " + parentId);

		Set<String> allId = driver.getWindowHandles();
		System.out.println("All Ids: " + allId);

		for (String winId : allId) {

			if (winId != parentId) {
				driver.switchTo().window(winId);
			}

		}
		Thread.sleep(5000);
		clickOnElement(a.getBuyNow());
	}


}
