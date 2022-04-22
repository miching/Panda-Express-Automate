/**
 * 
 */

/**
 * @author Michael Ching
 *
 */

import java.time.Duration;

import org.openqa.selenium.*;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(By.name("CN1")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		driver.quit();
		
		
	}

}
