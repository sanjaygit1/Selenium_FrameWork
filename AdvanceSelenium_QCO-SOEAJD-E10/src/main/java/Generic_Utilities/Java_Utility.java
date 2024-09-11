package Generic_Utilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility {

	/**
	 * This method is used to avoid Duplicates
	 * @return
	 * @author Shobha
	 */
	public  int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
	
	public static  String getSystemDateAndTime()
	{
		Date date = new Date();
		String dateAndTime = date.toString();
	System.out.println(dateAndTime);
		return dateAndTime;
		}
}
