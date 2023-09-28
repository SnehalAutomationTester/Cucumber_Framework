package com.cucumberframework.stepdefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumberframework.pageobjects.CheckOutPage;
import com.cucumberframework.utils.TestContextSetUp;

import io.cucumber.java.en.Then;

public class CheckOutPageStepDefination {
	public WebDriver driver;
	public String landingPageProductName;
	public CheckOutPage checkoutPage;
	TestContextSetUp textContextSetup;
	
	
	public CheckOutPageStepDefination(TestContextSetUp textContextSetup)
	{
		this.textContextSetup=textContextSetup;
		this.checkoutPage=textContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("^User proceed to checkout and validate the (.+) item in checkout page$")
	public void user_proceed_to_checkout_and_validate_the_item_in_checkout_page(String name) throws InterruptedException {
		checkoutPage.checkOutItems();
		Thread.sleep(3000);
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
	}

}
