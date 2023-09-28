package com.cucumberframework.stepdefination;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.cucumberframework.pageobjects.LandingPage;
import com.cucumberframework.pageobjects.OffersPage;
import com.cucumberframework.utils.TestContextSetUp;

import io.cucumber.java.en.Then;

public class OffersPageStepDefination {
	TestContextSetUp textContextSetup;
	public String offerPageProductName;
	public OffersPageStepDefination(TestContextSetUp textContextSetup)
	{
		this.textContextSetup=textContextSetup;
	}
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOfferPage();
	    //OffersPage offerPage=new OffersPage( textContextSetup.driver);
		OffersPage offerPage=textContextSetup.pageObjectManager.getOffersPage();
	    offerPage.searchItem(shortName);;
	    Thread.sleep(2000);
	    offerPageProductName=offerPage.getProductName();
	}
	
	public void switchToOfferPage() {
		    //LandingPage landingPage=new LandingPage(textContextSetup.driver);
		    LandingPage landingPage=textContextSetup.pageObjectManager.getLandingPage();
		    landingPage.selectTopDealsPage();
		    //textContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		    textContextSetup.genericUtils.switchToWindowChild();
		
	}
	
	@Then("Validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_Offers_Page() {
		Assert.assertEquals(textContextSetup.landingPageProductName, offerPageProductName);
	}
	
	/*@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOfferPage();
	    //OffersPage offerPage=new OffersPage( textContextSetup.driver);
		OffersPage offerPage=textContextSetup.pageObjectManager.getOffersPage();
	    offerPage.searchItem(shortName);;
	    Thread.sleep(2000);
	    offerPageProductName=offerPage.getProductName();
	}*/
	

}
