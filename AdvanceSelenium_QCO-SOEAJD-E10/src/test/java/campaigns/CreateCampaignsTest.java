package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.HomePage;

@Listeners(Generic_Utilities.ListenerEx.class)
public class CreateCampaignsTest extends BaseClass {

	@Test(retryAnalyzer =Generic_Utilities.RetryImp.class)
	public void createCampaignsTest() throws Throwable {

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		HomePage home = new HomePage(driver);
		home.clickOnMoreLink();
		home.clickOnCampLink();
		int ranNum = jlib.getRandomNum();
		CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
		campPage.clickHookUpImg();
		
	//	Assert.fail();
		String campName = elib.getExcelData("Campaigns", 0, 0)+ ranNum;

		campPage.enterCampName(campName);
		System.out.println(campName);

		campPage.clickSave();

		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		
//		SoftAssert soft = new SoftAssert();
//		soft.assertEquals(actData, campName+ranNum);
//		soft.assertAll();
	
	}
@Test
	public void m2()
	{
		System.out.println("--------im shobha----");
	}
}
