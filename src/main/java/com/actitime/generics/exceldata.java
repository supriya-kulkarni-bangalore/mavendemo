package com.actitime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class exceldata 
{
	public static String getData(String file_path,String sheet_name,int rn,int cn) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		
		try {
			
			FileInputStream f=new FileInputStream(new File(file_path));
			org.apache.poi.ss.usermodel.Cell c=(org.apache.poi.ss.usermodel.Cell) WorkbookFactory.create(f).getSheet(sheet_name).getRow(rn).getCell(cn);
			String data=c.getStringCellValue();
			return data;
			
		}
	
		catch (FileNotFoundException e) 
		{
			return null;
		}
	}
	
	public static int getLastRow(String file_path,String sheet_name) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		try {
			FileInputStream f=new FileInputStream(new File(file_path));
			int r=WorkbookFactory.create(f).getSheet(sheet_name).getLastRowNum();
			return r;
		} 
		catch (FileNotFoundException e) 
		{
			return 0;
		}
		
	}
	
	public static int getCellNo(String file_path,String sheet_name,int rn) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream f=new FileInputStream(new File(file_path));
		int l=WorkbookFactory.create(f).getSheet(sheet_name).getRow(rn).getLastCellNum();
		return l;
	}
		


}
