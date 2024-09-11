package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {


		//Step1:- give Connection between the physical file and test script
				FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\TestDataa.xlsx");

				//step2:-keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
			
			   //step3:-taking Control of the excel sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				int rowNum = sheet.getLastRowNum();
	            System.out.println(rowNum);
	
	       for (int i = 0; i < rowNum; i++)
	      {
		Row row = sheet.getRow(i);
		
		for (int j = 0; j <row.getLastCellNum(); j++)
		{
			Cell cell = row.getCell(j);
//			String links = cell.getStringCellValue();
//					System.out.println(links);
			
			DataFormatter format = new DataFormatter();
			String Links = format.formatCellValue(cell);
		 System.out.println(Links);
		}
	}
	
	}

}
