package com.cucumberframework.stepdefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumberframework.utils.TestContextSetUp;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestContextSetUp textContextSetup;
	public Hooks(TestContextSetUp textContextSetup)
	{
		this.textContextSetup=textContextSetup;
	}
	
	@After
	public void afterScenaio() throws IOException {
		textContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException {
		WebDriver driver=textContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			//after failing take screenshot
			File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
