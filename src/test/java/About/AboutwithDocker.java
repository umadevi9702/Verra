package About;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AboutwithDocker {
  @Test
  public void A() throws MalformedURLException {
	  
	  ChromeOptions opt=new ChromeOptions();	  
	  
	  @SuppressWarnings("deprecation")
	URL url=new URL("http://localhost:4444/wd/hub");	  
	  
	  RemoteWebDriver driver=new RemoteWebDriver(url, opt);
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get("https://verra.org/");	  
	  System.out.println("URL opened");
	  
	  driver.manage().window().maximize();	  
	  System.out.println("Window maximized");
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-15']//a[@class='mega-menu-link'][normalize-space()='About']")).click();
	  System.out.println("About tab clicked");
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-33198']//a[@class='mega-menu-link'][normalize-space()='Overview']")).click();
      System.out.println("Overview got clicked");
	  
	  driver.quit();
	  System.out.println("Window closed");
	  
	  
	  
	  
  }
}
