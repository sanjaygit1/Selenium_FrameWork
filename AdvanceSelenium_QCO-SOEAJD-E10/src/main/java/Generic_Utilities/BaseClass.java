package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public static	WebDriver sdriver;
	public WebDriver driver;
//	public static WebDriver sdriver;
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("DataBase Connection open");
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
//	public void BC(String BROWSER) throws Throwable
//	{
	public void BC() throws Throwable
	{
	    File_Utility flib = new File_Utility();
		String BROWSER = flib.getPropertiesData("Browser");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		   	 driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		System.out.println("Browser launched");
		sdriver = driver;
	}
	
//	@Parameters({"UserName","Password"})
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
//	public void BM(String UserName,String Password ) throws Throwable
//	{
		public void BM( ) throws Throwable
		{
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitPageToLoad(driver);

      //reading data from properties file		

		String URL = flib.getPropertiesData("Url");
		String USERNAME = flib.getPropertiesData("UserName");
		String PASSWORD = flib.getPropertiesData("PassWord");
		
		//reading url value from cmd line
//			String URL = System.getProperty("url");
//		    String USERNAME = System.getProperty("username");
//			String PASSWORD = System.getProperty("password");
		
         
		driver.get(URL);
		//using business logics
		LoginPage login = new LoginPage(driver);
		//while reading from xml file
	//	login.loginToApp(UserName, Password);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login To Application");
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM()
	{
		HomePage home = new HomePage(driver);
		 home.signOutApp(driver);
		System.out.println("LOgout from Application");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("close Browser");
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("Parallel execution done");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("Close DataBase Connection");
	}
}
