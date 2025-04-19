package Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamicvalue {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
		  driver.get("https://example.com/purchase-order");

          // Locate the submit button
          WebElement submitButton = driver.findElement(By.id("submitButtonId"));

          // Loop to check dynamic value multiple times
          for (int i = 0; i < 5; i++) { // Example loop for 5 iterations
              // Click the submit button
              submitButton.click();

              // Wait for the dynamic value to update (add explicit wait if needed)
              Thread.sleep(2000); // Example delay; replace with WebDriverWait for best practices

              // Locate and fetch the dynamic value
              WebElement dynamicValueElement = driver.findElement(By.id("dynamicValueId")); // Replace with actual ID
              String dynamicValue = dynamicValueElement.getText();
              
              
              
           // Define a flexible pattern or rule for validation (e.g., numeric or alphanumeric)
              String expectedCondition = "^[A-Z]{2}\\d{5}$"; // Example: Two letters followed by 5 digits (adjust as needed)
             // System.out.println("Uniqvalue: "+expectedCondition);

              // Validate the dynamic value (replace "expectedCondition" with your condition)
              boolean isValid = dynamicValue.matches(expectedCondition); // Example: regex or condition
              System.out.println("Dynamic value: " + dynamicValue + " | Valid: " + isValid);	
		
		
          }	
		
	}
		

	}


