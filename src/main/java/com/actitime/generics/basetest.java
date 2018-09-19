package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class basetest implements autoconstant
{
	public WebDriver driver;
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
	@BeforeMethod
	public void precondition()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
	}
	
	@AfterMethod
	public void postcondition(ITestResult res) throws WebDriverException, IOException
	{
		String testName=res.getName();
		int status=res.getStatus();
		
		if(status==2)
		{
			Reporter.log("test caes"+testName+"failed...",true);
			genericutils.takeScreenshot(driver, testName);
			Assert.fail();
		}
		else
		{
			Reporter.log("Test case"+testName+"passed...",true);
			
		}
		
		driver.close();
		
	}
}
