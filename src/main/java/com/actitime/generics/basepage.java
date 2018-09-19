package com.actitime.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class basepage  
{
	public WebDriver driver;
	public basepage(WebDriver driver)
	{
		driver=this.driver;
	}
	
	public void verfiyTitle(String etitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.titleIs(etitle));
			Reporter.log("title is matching....",true);
		}
		catch(Exception e)
		{
			Reporter.log("title is not matching...",true);
			Reporter.log("exxpected title is..."+etitle+"but actual title found is..."+driver.getTitle(),true);
			Assert.fail();
		}
	}
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("element is found....",true);
		}
		catch(Exception e)
		{
			Reporter.log("element is not found...",true);
			Assert.fail();
		}
	}
	
}
