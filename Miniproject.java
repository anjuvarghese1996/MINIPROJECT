package TestNG;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Miniproject {
	WebDriver driver;

	@BeforeTest 
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new  ChromeDriver();
	}
	@BeforeMethod
		public void navigate() {
			driver.get("https://demoqa.com/");
			driver.manage().window().maximize();
	}
	 @Test (priority = 1)
		 public void handleButtons() {
		        driver.get("https://demoqa.com/buttons");
		        
		        // Click the Click Me 
		        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
		        clickMeButton.click();
		        
		        WebElement clickMessage = driver.findElement(By.id("dynamicClickMessage"));
		        Assert.assertTrue(clickMessage.getText().contains("You have done a dynamic click"), "Click Me button not clicked correctly");
		        
		        // Double Click 
		        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
		        Actions actions = new Actions(driver);
		        actions.doubleClick(doubleClickButton).perform();
		        
		        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
		        Assert.assertTrue(doubleClickMessage.getText().contains("You have done a double click"), "Double Click button not clicked correctly");
		 }
	  @Test(priority = 2)
	   public void handleRadioButton() {
	   driver.get("https://demoqa.com/radio-button");
			            
			            
			       WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
			       yesRadio.click();
			            
			       WebElement outputText = driver.findElement(By.className("text-success"));
			       Assert.assertEquals(outputText.getText(), "Yes", "Yes radio button not selected correctly");
			            
			    }
	    @Test (priority = 3)
	      public void handleFrames() {
	    	   
	                 driver.get("https://demoqa.com/frames");
	                 driver.switchTo().frame("frame1");
	        
	                 WebElement heading = driver.findElement(By.id("sampleHeading"));
	                 Assert.assertEquals(heading.getText(), "This is a sample page");
	          
	                 driver.switchTo().defaultContent();
	    }
	     @Test (priority = 4)
	      public void handleDragAndDrop() {
	       
	    	   driver.get("https://demoqa.com/droppable");
	           WebElement source = driver.findElement(By.id("draggable"));
	           WebElement target = driver.findElement(By.id("droppable"));
	           
	           Actions actions = new Actions(driver);
	           actions.dragAndDrop(source, target).perform();
	            
	       }
	    @Test (priority = 5)
	     public void verifyLogoAndTitle() {
	     driver.get("https://demoqa.com");
	          
	           String expectedTitle = "DEMOQA";
	           String actualTitle = driver.getTitle();
	           Assert.assertTrue(actualTitle.contains(expectedTitle), "Title verification failed!");
	           
	           WebElement logo = driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
	           Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed!");
	       }

}
