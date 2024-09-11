package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
		
		//Step1:- give Connection between the physical file and test script
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\TestDataa.xlsx");

		//step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
	
	   //step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet("Sheet1");
	
		//step4:-taking Control of the rows
		Row row = sheet.getRow(0);
	
		//step5:-taking Control of the cell
		Cell cel = row.getCell(3);
	
		String excelData = cel.getStringCellValue();
	    System.out.println(excelData);
	
	
	}

}
