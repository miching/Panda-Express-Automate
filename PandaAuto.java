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
import org.openqa.selenium.support.ui.Select;
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
		  
		try 
		{
		
			//Open Panda Express Survey URL
			driver.get("https://www.pandaguestexperience.com/Index.aspx?POSType=SmartCode");
			
		}
		catch (Exception e)
		{
			
			System.out.println("Error retrieving site");
			
		}
		
		
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
		//wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textR000002"), "Please rate your overall satisfaction with your"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Answer survey question
		driver.findElement(By.xpath("//*[@id=\"FNSR000002\"]/td[1]")).click();
		
		//Next Page
		driver.findElement(By.id("NextButton")).click();
		
		try {
			
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		
		questionCheck(driver);
		
		
	/*
		//Question:The availability of menu items.
	//	driver.findElement(By.id("R000012.1")).click();
	//	driver.findElement(By.xpath("//*[@id=\"FNSR000286\"]/td[1]/span")).click();
	//	wait.until(ExpectedConditions.elementToBeSelected(By.id("R000012.1")));

		
		//Question: The portion size you received. 
	//	driver.findElement(By.id("R000011.1")).click();
	//	driver.findElement(By.xpath("//*[@id=\"FNSR000016\"]/td[1]")).click();
		//wait.until(ExpectedConditions.elementToBeSelected(By.id("R000011.1")));
		
		 
		//Question: The taste of your food.
	//	driver.findElement(By.id("R000008.1")).click();
	//	driver.findElement(By.xpath("//*[@id=\"FNSR000002\"]/td[1]")).click();
	//	wait.until(ExpectedConditions.elementToBeSelected(By.id("R000008.1")));
		
		 
		//Question: The temperature of your food.
	//	driver.findElement(By.id("R000009.1")).click();
	//	driver.findElement(By.xpath("//*[@id=\"FNSR000002\"]/td[1]")).click();
	//	wait.until(ExpectedConditions.elementToBeSelected(By.id("R000009.1")));
		
		 
		//Question: The freshness of your food.
	//	driver.findElement(By.id("R000212.1")).click();
		driver.findElement(By.xpath("//*[@id=\"FNSR000212\"]/td[1]")).click();
	//	wait.until(ExpectedConditions.elementToBeSelected(By.id("R000212.1")));
		
		//Question: Overall cleanliness
		driver.findElement(By.xpath("//*[@id=\"FNSR000018\"]/td[1]")).click();
		 
		//Next Page
		driver.findElement(By.id("NextButton")).click();
		
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textR000287"), "The visual appeal of your food"));
		 
		
		//Question: The visual appeal of your food
		driver.findElement(By.id("R000287.1")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000287.1")));
		
		
		//Question: The accuracy of your order.
		//driver.findElement(By.id("R000010.1")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000010.1")));
		driver.findElement(By.xpath("//*[@id=\"FNSR000010\"]/td[1]")).click();
		 
		
		//Question: The preparation of your food.
		driver.findElement(By.id("R000286.1")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000286.1")));
		 
		
		//Question: The overall value for the price you paid.
		driver.findElement(By.id("R000021.1")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000021.1")));
		 
		 
		//Next Page
		driver.findElement(By.id("NextButton")).click();
			
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textR000069"), "Did you have a problem during your experience?"));
		
			
		//Question: Did you have a problem during your experience?
		driver.findElement(By.id("R000069.2")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000069.2")));
			
		
		//Next Page
		driver.findElement(By.id("NextButton")).click();
					
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textR000073"), "Recommend this "));
		
		
		//Question: Recommend this Panda Express to others in the next 30 days?
		driver.findElement(By.id("R000073.5")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000073.5")));
		
		
		//Question: Return to this Panda Express in the next 30 days?
		driver.findElement(By.id("R000072.5")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000072.5")));
		
		
		
		//Next Page
		driver.findElement(By.id("NextButton")).click();
							
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textS000077"), "Please tell us in three or more sentences"));
		
		driver.findElement(By.id("gauge_S000077")).sendKeys("I like pandas!");
		
		
		
		
		//Next Page
		driver.findElement(By.id("NextButton")).click();
									
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textR000078"), "Please rate your satisfaction with the changes this \n" + 
				"        Panda Express location has made in response to the current health crisis."));
		
		//Question: "Please rate your satisfaction with the changes this Panda Express location has made in response to the current health crisis."
		driver.findElement(By.id("R000078.5")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000078.5")));
		
		
		
		
		//Next Page
		driver.findElement(By.id("NextButton")).click();
											
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textR000466"), "How likely is it that you will enter the"));
		
		
		//Question: How likely is it that you will enter the "Embrace Your Inner Panda" Sweepstakes?
		driver.findElement(By.id("R000466")).click();
		wait.until(ExpectedConditions.elementToBeSelected(By.id("R000466")));
		
		
		
		//Next Page
		driver.findElement(By.id("NextButton")).click();
													
		//Check if on next page
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("textBlock2250"), "These final questions are for classification purposes only"));
		
		
		//Question: Please select your gender
		Select selectByValue = new Select(driver.findElement(By.id("R000130")));
		selectByValue.selectByVisibleText("Male");
		//selectByValue.selectByValue("2");
		//selectByValue.selectByIndex(2);
		
		
		//Question: Please select your age
		selectByValue = new Select(driver.findElement(By.id("R000131")));
		selectByValue.selectByValue("2");
				
				
		//Question: Please select your annual household income:
		selectByValue = new Select(driver.findElement(By.id("R000132")));
		selectByValue.selectByValue("9");
				
		
		//Question: Please select which of the following best describes your background
		selectByValue = new Select(driver.findElement(By.id("R000133")));
		selectByValue.selectByValue("2");
		
		
		//Next Page
		//driver.findElement(By.id("NextButton")).click();

	*/	
		
		//End of Survey
		//driver.close();
		//driver.quit();
		
		
	}
	
	
	public static void questionCheck(WebDriver driver)
	{
		
		try {
			
			//Question: The speed of service
			driver.findElement(By.xpath("//*[@id=\"FNSR000015\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("Speed of Service question not here");
			
		}
		
		
		try {
			
			//Question: The availability of menu items.
			driver.findElement(By.xpath("//*[@id=\"FNSR000012\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The availability of menu items question not here");
			
		}
		
		
		try {
			
			//Question: The portion size you received. 
			driver.findElement(By.xpath("//*[@id=\"FNSR000011\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The portion size you received question not here");
			
		}
		
		
		try {
			
			//Question: The taste of your food. 
			driver.findElement(By.xpath("//*[@id=\"FNSR000008\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The taste of your food question not here");
			
		}
		
		
		try {
			
			//Question: The temperature of your food.
			driver.findElement(By.xpath("//*[@id=\"FNSR000009\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The temperature of your food question not here");
			
		}
		
		
		try {
			
			//Question: The freshness of your food.
			driver.findElement(By.xpath("//*[@id=\"FNSR000212\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The freshness of your food question not here");
			
		}
		
		
		try {
			
			//Question: Overall cleanliness.
			driver.findElement(By.xpath("//*[@id=\"FNSR000018\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("Overall cleanliness question not here");
			
		}
		
		
		try {
			
			//Question: The visual appeal of your food.
			driver.findElement(By.xpath("//*[@id=\"FNSR000287\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The visual appeal of your food question not here");
			
		}
		
		
		try {
			
			//Question: The accuracy of your order.
			driver.findElement(By.xpath("//*[@id=\"FNSR000010\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The accuracy of your order question not here");
			
		}
			
				
		try {
			
			//Question: The preparation of your food.
			driver.findElement(By.xpath("//*[@id=\"FNSR000286\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The preparation of your food question not here");
			
		}
		
			
		try {
			
			//Question: The overall value for the price you paid.
			driver.findElement(By.xpath("//*[@id=\"FNSR000021\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The overall value for the price you paid question not here");
			
		}
		
		
		try {
			
			//Question: The ease of placing your order.
			driver.findElement(By.xpath("//*[@id=\"FNSR000013\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("The ease of placing your order question not here");
			
		}
		
		
		try {
			
			//Question: The friendliness of the team members.
			driver.findElement(By.xpath("//*[@id=\"FNSR000016\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("TThe friendliness of the team members question not here");
			
		}
							 
		try {
			
			//Question: Did you have a problem during your experience?
			driver.findElement(By.xpath("//*[@id=\"FNSR000069\"]/td[2]")).click();
			
		} catch (Exception e) {
			
			System.out.println("Did you have a problem during your experience question not here");
			
		}
				
		
		try {
			
			//Question: Recommend this Panda Express to others in the next 30 days?
			driver.findElement(By.xpath("//*[@id=\"FNSR000073\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("Recommend this Panda Express to others in the next 30 days question not here");
			
		}
			
		
		try {
			
			//Question: Return to this Panda Express in the next 30 days?
			driver.findElement(By.xpath("//*[@id=\"FNSR000072\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("Return to this Panda Express in the next 30 days question not here");
			
		}
		
		
		try {
			
			//Question: Including this visit, how many times have you visited Panda Express in the past 30 days?
			driver.findElement(By.xpath("//*[@id=\"FNSR000086\"]/div/div/div[3]/span/span")).click();
			
		} catch (Exception e) {
			
			System.out.println("Including this visit, how many times have you visited Panda Express in the past 30 days question not here");
			
		}
			
				
		try {
			
			//Question: User Input
			driver.findElement(By.id("gauge_S000077")).sendKeys("I like pandas!");
			
		} catch (Exception e) {
			
			System.out.println("User Input not here");
			
		}
		
			
		try {
			
			//Question: Please rate your satisfaction with the changes this Panda Express location has made in response to the current health crisis.
			driver.findElement(By.xpath("//*[@id=\"FNSR000078\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("Please rate your satisfaction with the changes this Panda Express location has made in response to the current health crisis question not here");
			
		}
		
		
		try {
			
			//Question: Please rate your satisfaction with how Panda Express protected your health and safety during your visit.
			driver.findElement(By.xpath("//*[@id=\"FNSR000381\"]/td[1]")).click();
			
		} catch (Exception e) {
			
			System.out.println("Please rate your satisfaction with how Panda Express protected your health and safety during your visit question not here");
			
		}
		
		
		try {
			
			//Question: Would you like to recognize an employee by name for going above and beyond to provide exceptional service?
			driver.findElement(By.xpath("//*[@id=\"FNSR000083\"]/td[2]")).click();
			
		} catch (Exception e) {
			
			System.out.println("Would you like to recognize an employee by name for going above and beyond to provide exceptional service question not here");
			
		}
			
			
		try {
			
			//Question: How likely is it that you will enter the "Embrace Your Inner Panda" Sweepstakes?
			driver.findElement(By.xpath("//*[@id=\"FNSR000466\"]/td[4]")).click();
			
		} catch (Exception e) {
			
			System.out.println("How likely is it that you will enter the \"Embrace Your Inner Panda\" Sweepstakes? question not here");
			
		}
			
		
		/*	
			
			
			
			
			//Question: Please select your gender
			Select selectByValue = new Select(driver.findElement(By.id("R000130")));
			selectByValue.selectByVisibleText("Male");
			//selectByValue.selectByValue("2");
			//selectByValue.selectByIndex(2);
			
			
			//Question: Please select your age
			selectByValue = new Select(driver.findElement(By.id("R000131")));
			selectByValue.selectByValue("2");
					
					
			//Question: Please select your annual household income:
			selectByValue = new Select(driver.findElement(By.id("R000132")));
			selectByValue.selectByValue("9");
					
			
			//Question: Please select which of the following best describes your background
			selectByValue = new Select(driver.findElement(By.id("R000133")));
			selectByValue.selectByValue("2");
			
			
			//Next Page
			//driver.findElement(By.id("NextButton")).click();
	*/	
		
		
	}

}
