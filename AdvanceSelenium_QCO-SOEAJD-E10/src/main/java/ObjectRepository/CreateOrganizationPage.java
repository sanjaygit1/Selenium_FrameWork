package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(name="accountna"),@FindBy(xpath = "//input[@name='accountname']")})
	private WebElement OrganizationName;
	
	@FindBy(id="phone")
	private WebElement phnNum;
	
	@FindBy(id="email1")
	private WebElement emailId;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement clickOnSaveButton;
	
	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public void enterOrgData(String OrgName,String phoneNum,String mailId)
	{
		OrganizationName.sendKeys(OrgName);
		phnNum.sendKeys(phoneNum);
		emailId.sendKeys(mailId);
		
	}
	public void clickOnSave()
	{
		clickOnSaveButton.click();
	}
	
}
