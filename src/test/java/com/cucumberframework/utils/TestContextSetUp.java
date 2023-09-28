package com.cucumberframework.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.cucumberframework.pageobjects.PageObjectManager;

public class TestContextSetUp {
	
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;
	//public Object genericUtils;
	public TestContextSetUp() throws IOException {
		testBase=new TestBase();
		pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
		genericUtils=new GenericUtils(testBase.WebDriverManager());
	}
}
