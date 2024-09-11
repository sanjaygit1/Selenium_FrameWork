package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {

	public ValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public  void ValidatePrd(WebDriver driver,String data)
	{
	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
		if(actData.contains(data))
		{
			System.out.println("Product created");
		}
		else
		{
			System.out.println("Product not created");
		}
	}
	
	public  String ValidatePrd1(WebDriver driver)
	{
	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	return actData;
		
	}
	}
