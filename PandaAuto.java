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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		  
		//Open Panda Express Survey URL
		driver.get("https://www.pandaguestexperience.com/Index.aspx?POSType=SmartCode");
		
		//Enter code values into proper elements
		driver.findElement(By.name("CN1")).sendKeys(code.substring(0, 4));
		driver.findElement(By.name("CN2")).sendKeys(code.substring(4, 8));
		driver.findElement(By.name("CN3")).sendKeys(code.substring(8, 12));
		driver.findElement(By.name("CN4")).sendKeys(code.substring(12, 16));
		driver.findElement(By.name("CN5")).sendKeys(code.substring(16, 20));
		driver.findElement(By.name("CN6")).sendKeys(code.substring(20, 22));
		
		//Add explicit wait condition for all values to be entered in
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.name("CN6"), code.substring(20, 22)));
		
		
		
		/*
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//Next Page
		driver.findElement(By.id("NextButton")).click();
		
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textR000002"), "Please rate your overall satisfaction with your"));
		
		//Answer survey question
		driver.findElement(By.id("R000002.1")).click();
		
		//Next Page
		driver.findElement(By.id("NextButton")).click();
		
		
		//Question: The speed of service
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000015.1")));
		driver.findElement(By.id("R000015.1")).click();
		
		
		//Question:The availability of menu items.
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000012.1")));
		driver.findElement(By.id("R000012.1")).click();
		
		//Question: The portion size you received.  
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000011.1")));
		driver.findElement(By.id("R000011.1")).click();
		 
		//Question: The taste of your food.
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000008.1")));
		driver.findElement(By.id("R000008.1")).click();
		 
		 
		//Question: The temperature of your food.
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000009.1")));
		driver.findElement(By.id("R000009.1")).click();
		 
		//Question: The freshness of your food.
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000212.1")));
		driver.findElement(By.id("R000212.1")).click();
		 
		 
		//Next Page
		driver.findElement(By.id("NextButton")).click();
		
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textR000002"), "Please rate your overall satisfaction with your"));
		
		//driver.quit();
		
		
	}

}
