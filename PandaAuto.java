/**
 * 
 */

/**
 * @author Michael Ching
 *
 */

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.safari.SafariDriver;

public class PandaAuto
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	
		
		//WebDriver driver = new SafariDriver(); 
		SafariOptions options = new SafariOptions();
		WebDriver  driver = new SafariDriver(options);
		  
	
		driver.get("https://www.pandaguestexperience.com/Index.aspx?POSType=SmartCode");
		driver.quit();
		
		
	}

}
