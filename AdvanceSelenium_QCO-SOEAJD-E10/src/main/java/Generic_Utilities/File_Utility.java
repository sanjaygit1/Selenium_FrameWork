package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to read data from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getPropertiesData(String key) throws Throwable
	{
	//		step1:-get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData7.properties");
		
		//step2:-create an object to property class to load all the keys
		    Properties pro = new Properties();
		    pro.load(fis);
		    
		    //step3:-read the value using getProperty()
		    String value = pro.getProperty(key);
		    return value;
		
	}
	
	
	
}
