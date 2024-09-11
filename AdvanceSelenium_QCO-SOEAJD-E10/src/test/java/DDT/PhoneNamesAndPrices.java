package DDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class PhoneNamesAndPrices {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        
        driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);
        
//        int count=0;
//        List<WebElement> phnNames = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
//	
//	for (WebElement phne : phnNames)
//	{
//		System.out.println(phne.getText());
//		count++;
//	}
//	System.out.println("total num of count:----->"+count);
//----------------------------------------------------------------------------------------------------------------------------------------
//        int count=0;
//       List<WebElement> phnPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
//	for (WebElement phne : phnPrice)
//	{
//		System.out.println(phne.getText());
//		count++;
//	}
//	System.out.println("total num of count:----->"+count);
	
 //---------------------------------------------------------------------------------------------------------------------------------------
        
        List<WebElement> phnNames = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        List<WebElement> phnPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
        
        for (int i = 0; i < phnNames.size(); i++) 
        {
			System.out.println(phnNames.get(i).getText()+"----------->"+phnPrice.get(i).getText());
		}
	}

}
