package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Decalartion
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(css = "[name=\"user_password\"]")
	private WebElement PassWordTextField;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement LoginButton;

	//getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}	
	
	//BusinessLogics
	public void loginToApp(String UserName,String PassWord)
	{
		UserTextField.sendKeys(UserName);
		PassWordTextField.sendKeys(PassWord);
		LoginButton.click();
	}
	
	
}
