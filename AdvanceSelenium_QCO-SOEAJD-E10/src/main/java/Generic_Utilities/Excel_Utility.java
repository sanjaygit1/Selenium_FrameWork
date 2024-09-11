package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * this method is used to read data from Excel file
	 * @param SheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getExcelData(String SheetName,int rowNum,int celNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream(
				"C:\\Users\\Shobha\\eclipse-BasicSelenium\\AdvanceSelenium_QCO-SOEAJD-E10\\target\\test-classes\\TestData7.xlsx");
		// step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet(SheetName);

		// step4:-taking Control of the rows
		Row row = sheet.getRow(rowNum);

		// step5:-taking Control of the cell
		Cell cel = row.getCell(celNum);

		String Exceldata = cel.getStringCellValue();
		return Exceldata;
		
	}
	
	public String getExcelDataUsingFormatter(String SheetName,int rowNum,int celNum) throws Throwable
	{
		//Step1:- give Connection between the physical file and test script
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Shobha\\\\eclipse-BasicSelenium\\\\AdvanceSelenium_QCO-SOEAJD-E10\\\\target\\\\test-classes\\\\TestData7.xlsx");

		//step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
	
	   //step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet(SheetName);
	
		//step4:-taking Control of the rows
		Row row = sheet.getRow(rowNum);
	
		//step5:-taking Control of the cell
		Cell cel = row.getCell(celNum);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cel);
		System.out.println(ExcelData);
		return ExcelData;
		
	}
	public Object[][] getDataProviderData(String sheetName) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\eclipse-BasicSelenium\\AdvanceSelenium_QCO-SOEAJD-E10\\target\\test-classes\\TestData7.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i <lastRow ; i++)
		{
		for (int j = 0; j <lastCell ; j++)
		{
			objArr[i][j]=sheet.getRow(i).getCell(j).toString();
		}	
		}
		
		return objArr;
		
	}
	
	
}
