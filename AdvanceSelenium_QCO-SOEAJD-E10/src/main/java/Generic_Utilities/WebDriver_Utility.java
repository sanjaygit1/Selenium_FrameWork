package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {

	/**
	 * This method is used to maximize the window/webpage
	 * @param driver
	 * @author Shobha
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the window/webpage
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to FullScreen the window/webpage
	 * @param driver
	 */
	public void FullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method is used to wait element to get loaded in window/webpage
	 * @param driver
	 */
	public void waitPageToLoad(WebDriver driver)
	
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method is used for switching windows/tabs
	 * @param driver
	 * @param title
	 */
	public void switchingWindows(WebDriver driver, String title)
	{
		Set<String> allWin = driver.getWindowHandles(); // win1,win2

		Iterator<String> it = allWin.iterator();
		while (it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();

			if (currentTitle.contains(title))
			{
				break;
			}
		}
	}
	
    public  void moveToElementAction(WebDriver driver,WebElement ele)
		{
    	Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
		}	

//public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable {
//	
//	Java_Utility jlib = new Java_Utility();
//	
//	TakesScreenshot ts = (TakesScreenshot)driver;
//	File src = ts.getScreenshotAs(OutputType.FILE);
//	String path = "./ScreenShot/"+screenShotName+" "+jlib.getSystemDateAndTime()+".png";
//	File dest = new File(path);
//	String srcPath = dest.getAbsolutePath();
//	FileUtils.copyFile(src, dest);
//	
//	return srcPath;	
//		}

public static String takeScreenShot1(WebDriver driver, String screenShotName) throws Throwable {
	
	TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
	File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
	File dst = new File("./ScreenShots/" + screenShotName +".png");
	FileUtils.copyFile(src, dst);
	return dst.getAbsolutePath();
}
}
