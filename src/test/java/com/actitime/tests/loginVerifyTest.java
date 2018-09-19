package com.actitime.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.actitime.generics.basetest;
import com.actitime.generics.exceldata;
import com.actitime.pages.loginPage;

public class loginVerifyTest extends basetest
{
	@Test(priority=1)
	public void testLogin() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String un=exceldata.getData(file_path, "TC01", 1, 0);
		String pass=exceldata.getData(file_path, "TC01", 1, 1);
		
		loginPage lp=new loginPage(driver);
		
		lp.enterUserName(un);
		lp.enterPassword(pass);
		
		lp.clickOnLogin();
	}
	
}
