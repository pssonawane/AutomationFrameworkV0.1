package com.qa.demo.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.qa.demo.base.TestBase;

public class ReadDataFromExcel extends TestBase{

	public static Workbook book;
	public static FileInputStream ip;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static Object[][] getdataFromExcel() {
		
		File file = new File(userDirectory+"\\src\\main\\java\\com\\qa\\demo\\testData\\newtours.xls");
		try {
			ip = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = new HSSFWorkbook(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("Sheet1");
		Object object[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i< sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				object[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return object;
	}
	
}
