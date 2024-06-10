package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class Excel3 {
	//@DataProvider(parallel=true)
	public static String[][] throwData(String fileName) throws IOException {
		//File fileName=new File("./Data/Test.xlsx");
		//FileInputStream inp=new FileInputStream(fileName);
		Workbook book=new XSSFWorkbook("./Data/"+fileName+".xlsx");
		Sheet sheet = book.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println("Exclusive of Heaers"+rowNum+"\n"+"Inclusive of Headers"+rows);
		short cellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("no of cells"+cellNum);
		String[][] data=new String[rowNum][cellNum];
		for (int i = 1; i <=rowNum; i++) {
			Row row = sheet.getRow(i);
		    for (int j = 0; j < cellNum; j++) {
		    	Cell cell = row.getCell(j);
		    	DataFormatter frm=new DataFormatter();
		    String cellValue = frm.formatCellValue(cell);
		    	//System.out.println(cellValue);
		    data[i-1][j]=cellValue;
				
			}
		   }
		
		book.close();
		  return data;
	}
	  //NullPointrException
    //IllegalStateException
    //FileNotFoundException
	
}
