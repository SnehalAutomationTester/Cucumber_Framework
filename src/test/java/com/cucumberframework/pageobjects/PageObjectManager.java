package com.cucumberframework.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public OffersPage offersPage;
	public WebDriver driver;
	public CheckOutPage checkoutPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingPage =new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage()
	{
		offersPage =new OffersPage(driver);
		return offersPage;
	}
	
	public CheckOutPage getCheckoutPage()
	{
		checkoutPage =new CheckOutPage(driver);
		return checkoutPage;
	}
	

}
