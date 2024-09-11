package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.WindowSwitchingCampWithPrd;

public class CreateCampaignsWithProductTest extends BaseClass {

	@Test
	public void CreateCampaignsWithProductTest() throws Throwable {

		WebDriver driver = new ChromeDriver();

		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		wlib.maximizeWindow(driver);
		wlib.waitPageToLoad(driver);

		// reading data from properties file

		String URL = flib.getPropertiesData("Url");
		String USERNAME = flib.getPropertiesData("UserName");
		String PASSWORD = flib.getPropertiesData("PassWord");

		driver.get(URL);

		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);
		home.clickProductLink();

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickPrdHookUp();

		// TO avoid Duplicates
		int ranNum = jlib.getRandomNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;

		prdPage.enterPrdNAme(prdName);
		prdPage.clickSaveButton();

		
		home.clickOnMoreLink();
		home.clickOnCampLink();

		CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
		campPage.clickHookUpImg();

//----------------------------------------------------------------------------------------------------------------				  
//Navigating to campaigns module	
		String campName = elib.getExcelData("Campaigns", 0, 0);

		campPage.enterCampName(campName);
		campPage.clickOnPrdWinLink();

		wlib.switchingWindows(driver, "Products&action");

		WindowSwitchingCampWithPrd switching = new WindowSwitchingCampWithPrd(driver);
		switching.enterPrdName(prdName);
		switching.clickOnSearchBar();
		switching.clickOnprdName(driver, prdName);

		wlib.switchingWindows(driver, "Campaigns&action");
        campPage.getSaveButton();

        
	}
}
