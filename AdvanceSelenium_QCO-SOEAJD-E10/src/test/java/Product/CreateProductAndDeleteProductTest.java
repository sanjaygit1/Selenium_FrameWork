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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.DeletePrdName;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateProductAndDeleteProductTest extends BaseClass {

	//@Test
	public void createProductAndDeleteProductTest() throws Throwable {
		
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();


		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickPrdHookUp();

		int ranNum = jlib.getRandomNum();
		
		String prdName = elib.getExcelData("Product", 0, 0)+ranNum;
        System.out.println(prdName);

        prdPage.enterPrdNAme(prdName);
        prdPage.clickSaveButton();

        //Navigating to product table

         home.clickProductLink();
        
		//Dynamic xpath
         DeletePrdName deletePrd = new DeletePrdName(driver);
        deletePrd.selectPrdData(driver, prdName);
        
       //click on delete button
        deletePrd.clickOnDeleteBotton();

        //Hndling Alert popup(Accept)
		driver.switchTo().alert().accept();
		
		Thread.sleep(4000);
		deletePrd.validatePrdDeleted(driver, prdName);
	//	home.logOutFromApp();
	}

}
