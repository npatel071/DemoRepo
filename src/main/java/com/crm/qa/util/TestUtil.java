package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
public static long PAGE_LOAD_TIMEOUT = 10;
public static long IMPLICIT_TIMEOUT = 5;

public static String TESTDATA_SHEET_PATH= "C:\\Users\\Dhaval\\Desktop\\FreeCRMTestData.xlsx";

static Workbook book;
static Sheet sheet;


public void switchToFrame(){
	driver.switchTo().frame("mainpanel");
}

public static Object[][] getTestData(String sheetname) throws Exception{
	FileInputStream file = null;
	file = new FileInputStream(TESTDATA_SHEET_PATH);
	book= WorkbookFactory.create(file);
	sheet=(Sheet) book.getSheet(sheetname);
	Object[][] data = new Object[((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()][((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum()];
	for(int i=0; i<=)
	
	return data;
	
}
}
