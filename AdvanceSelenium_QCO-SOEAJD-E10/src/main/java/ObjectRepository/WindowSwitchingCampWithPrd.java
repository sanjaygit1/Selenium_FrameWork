package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingCampWithPrd {

	public WindowSwitchingCampWithPrd(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement prdTextfield;
	
	@FindBy(xpath = "//input[@type=\"button\"]")
	private WebElement searchBar;
	
	public void enterPrdName(String prdName)
	{
		prdTextfield.sendKeys(prdName);
	}
	
	public void clickOnSearchBar()
	{
		searchBar.click();
	}
	public void clickOnprdName(WebDriver driver,String prdName )
	{
		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
	}
	
	
}
