package com.cucumberframework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


	public class CheckOutPage {
		
		public WebDriver driver;
		
		public CheckOutPage(WebDriver driver) {
			this.driver=driver;
		}


		
		By cartBag=By.cssSelector("img[alt='Cart']");
		By checkOutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
		By promoButton=By.cssSelector(".promoBtn");
		By placeOrderButton=By.xpath("//button[contains(text(),'Place Order')]");
		
		public void checkOutItems() {
			driver.findElement(cartBag).click();
			driver.findElement(checkOutButton).click();
		}
		
		public Boolean verifyPromoBtn() {
			return driver.findElement(promoButton).isDisplayed();
		}
		

		public Boolean verifyPlaceOrderButton() {
			return driver.findElement(placeOrderButton).isDisplayed();
		}
	}

