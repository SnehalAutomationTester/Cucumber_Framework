package com.cucumberframework.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.cucumberframework.pageobjects.LandingPage;
import com.cucumberframework.pageobjects.PageObjectManager;
import com.cucumberframework.utils.TestContextSetUp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageStepDefination {
	public WebDriver driver;
	public String landingPageProductName;
	TestContextSetUp textContextSetup;
	public LandingPage landingPage;
	
	
	public LandingPageStepDefination(TestContextSetUp textContextSetup)
	{
		this.textContextSetup=textContextSetup;
		this.landingPage=textContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		
		Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));
	}
	@When("^User searched with Shortname (.+) extracted actual name of the product$")
	public void user_searched_with_shortname_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		
		 landingPage.searchItem(shortName);
 	     Thread.sleep(2000);
	     textContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
	     System.out.println("Product name on home page is "+textContextSetup.landingPageProductName);
	}
	
	/*@When("User searched with Shortname {string} extracted actual name of the product")
	public void user_searched_with_shortname_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		 LandingPage landingPage=textContextSetup.pageObjectManager.getLandingPage();
		 landingPage.searchItem(shortName);
 	     Thread.sleep(2000);
	     textContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
	     System.out.println("Product name on home page is "+textContextSetup.landingPageProductName);
	}*/
	
	@When("Added {string} items of the seleceted product to cart")
	public void added_items_of_the_seleceted_product_to_cart(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
}
