package testNgPratice;

import org.testng.annotations.Test;


public class SampleTest {

	@Test(invocationCount = 3)
	public void createProductTest()
	{
		System.out.println("product created");
	}
	
	@Test
	public void modifyProductTest()
	{
		System.out.println("product modified");
	}
	
	@Test
	public void deleteProductTest()
	{	
		System.out.println("product deleted");
	}
}
