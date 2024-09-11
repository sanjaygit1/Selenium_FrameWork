package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DynamicXpathEx {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
//		driver.get("https://olympics.com/en/paris-2024");
//		driver.manage().window().maximize();
//		
//		Thread.sleep(2000);
//		String gold = driver.findElement(By.xpath("//span[text()='Japan']/../..//span[@data-cy=\"number-of-golds\"]")).getText();
//	System.out.println(gold);
//	
//	
//	String silver = driver.findElement(By.xpath("(//span[text()='Japan']/../..//span[@class='sc-bdnyFh bjnoKy MedalsTallyElement-styles__MedalCounter-sc-d9279d18-0 hlLVoN text--number-xs'])[1]")).getText();
//	System.out.println(silver);
		
		
		
		driver.get("https://www.prokabaddi.com/standings");
		
	String teamName = "Jaipur Pink Panthers";
		String wonMatches = driver.findElement(By.xpath("//p[text()='"+teamName+"']/../../../..//div[@class='table-data matches-won']")).getText();
	System.out.println(wonMatches);
	
	String lostMatches = driver.findElement(By.xpath("//p[text()='"+teamName+"']/../../../following-sibling::div[@class='table-data matches-lost']")).getText();
	System.out.println(lostMatches);
	
	}

}
