package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteSingleDataToExcelFile {

	public static void main(String[] args) throws Throwable {
		
		//Step1:- give Connection between the physical file and test script
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\TestDataa.xlsx");

				//step2:-keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
			
			   //step3:-taking Control of the excel sheet
				Sheet sheet = book.getSheet("Sheet1");
				
			   //step4:-taking Control of the row 
				Row row = sheet.createRow(7);
	
				//step5:-taking Control of the cel
				Cell cel = row.createCell(5);
				
				//step6:-insert data to the perticular cell
				cel.setCellValue("Qspiders");
				
				//step7:- keep excel book in write mode
	 FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\Shobha\\\\Downloads\\\\TestDataa.xlsx");
				book.write(fos);
				book.close();
	
	}

}
