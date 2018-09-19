package com.actitime.generics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public abstract class genericutils 
{
	public static void takeScreenshot(WebDriver driver,String name) throws WebDriverException, IOException
	{
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File dest= new File("./src/test/resources/screenshots/"+name+".png");
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), dest);
		
		
	}
}
