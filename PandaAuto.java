/**
 * 
 */

/**
 * @author Michael Ching
 *
 */

import java.time.Duration;
import java.util.Scanner;

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
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your panda express code:");
		String code = scan.nextLine();
		
		//Check code is proper length
		while(code.length() != 22)
		{
			
			System.out.println("Code is not proper length");
			code = scan.nextLine();
			
		}
		
		
		WebDriver driver = new SafariDriver(); 
		//SafariOptions options = new SafariOptions();
		//WebDriver  driver = new SafariDriver(options);
		  
	
		driver.get("https://www.pandaguestexperience.com/Index.aspx?POSType=SmartCode");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(By.name("CN1")).sendKeys(code.substring(0, 4));
		driver.findElement(By.name("CN2")).sendKeys(code.substring(4, 8));
		driver.findElement(By.name("CN3")).sendKeys(code.substring(8, 12));
		driver.findElement(By.name("CN4")).sendKeys(code.substring(12, 16));
		driver.findElement(By.name("CN5")).sendKeys(code.substring(16, 20));
		driver.findElement(By.name("CN6")).sendKeys(code.substring(20, 22));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.findElement(By.id("NextButton")).click();
		
		//driver.quit();
		
		
	}

}
