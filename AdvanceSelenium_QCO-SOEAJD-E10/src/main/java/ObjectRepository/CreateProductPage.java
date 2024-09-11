package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
    private WebElement clickHookUpImg;
	
	@FindBy(name="productname")
	private WebElement prdName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	public void clickPrdHookUp()
	{
		clickHookUpImg.click();
	}
	
	public void enterPrdNAme(String name)
	{
		prdName.sendKeys(name);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();	
	}
	
}
