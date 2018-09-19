package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.basepage;

public class loginPage extends basepage
{

	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameTB;
	
	@FindBy(name="pwd")
	private WebElement passwordTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	public loginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void  enterUserName(String un)
	{
		userNameTB.sendKeys(un);
	}
	
	public void enterPassword(String pwd)
	{
		passwordTB.sendKeys(pwd);
		
	}
	
	public void clickOnLogin()
	{
		loginBTN.click();
	}
	

}
