package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeletePrd {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// reading data from properties file
//				step1:-get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData7.properties");

		// step2:-create an object to property class to load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:-read the value using getProperty()
		String URL = pro.getProperty("Url");
		String USERNAME = pro.getProperty("UserName");
		String PASSWORD = pro.getProperty("PassWord");

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

		// TO avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		//Reading Data from Excel
		FileInputStream fes = new FileInputStream(
				"C:\\Users\\Shobha\\eclipse-BasicSelenium\\AdvanceSelenium_QCO-SOEAJD-E10\\target\\test-classes\\TestData7.xlsx");
		// step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet("Product");

		// step4:-taking Control of the rows
		Row row = sheet.getRow(0);

		// step5:-taking Control of the cell
		Cell cel = row.getCell(0);

		String prdName = cel.getStringCellValue() + ranNum;
		//System.out.println(prdName);

		driver.findElement(By.name("productname")).sendKeys(prdName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		//Navigating to product table
		driver.findElement(By.linkText("Products")).click();

		// driver.findElement(By.xpath("//table[@class='lvt
		// small']/tbody/tr//td//a[text()='Product
		// Name']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();

		//Dynamic xpath
	//	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + prdName
	//			+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+prdName+"']/../../td/input")).click();

		
		//click on delete button
			driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

			//Hndling Alert popup(Accept)
		driver.switchTo().alert().accept();
		
	Thread.sleep(4000);
		List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		boolean flag=false;
			 
			 for(WebElement prdName1:productList)
			 {
				String actData = prdName1.getText();
				System.out.println(actData);
				if(actData.equalsIgnoreCase(prdName))
				{
					System.out.println("product data is not deleted");
					flag=true;
					break;
				}
			 }
			 System.out.println(flag);
			if(flag==false)
			{
				System.out.println("product data is deleted");
			}
	}

}
