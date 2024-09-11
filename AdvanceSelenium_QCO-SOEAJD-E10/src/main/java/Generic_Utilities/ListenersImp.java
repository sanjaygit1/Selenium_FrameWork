package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImp implements ITestListener
{

	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot)BaseClass.sdriver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./FailesScripts.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
