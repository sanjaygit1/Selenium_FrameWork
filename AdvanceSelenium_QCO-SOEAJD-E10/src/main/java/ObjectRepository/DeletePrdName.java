package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePrdName {

	public DeletePrdName(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement deleteButton;
	
	public void selectPrdData(WebDriver driver,String prdName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + prdName
				+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
}
	
	public void clickOnDeleteBotton()
	{
		deleteButton.click();
	}
	
	public void validatePrdDeleted(WebDriver driver,String prdName)
	{
		List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		 boolean flag=false;
			 
		 for(WebElement prdName1:productList)
		 {
			String actData = prdName1.getText();
			System.out.println(actData);
			if(actData.equalsIgnoreCase(prdName))
			{
				flag=true;
				break;
			}
		 }
		 System.out.println(flag);
		if(!flag)
		{
			System.out.println("product data is deleted");
		}else {
			System.out.println("product data is not deleted");
		}
	}
}
