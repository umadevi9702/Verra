package Latest;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerraViews {
	
	WebDriver driver;
	
  @Test
  public void A() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addArguments("--headless=new");
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://verra.org/");
	  System.out.println("URL Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-19']//a[@class='mega-menu-link'][normalize-space()='Latest']")).click();
	  System.out.println("Latest tab clicked");
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-37310']//a[@class='mega-menu-link'][normalize-space()='Verra Views']")).click();
	  System.out.println("Verra Views got clicked");
	  
	  driver.quit();
	  System.out.println("Window closed");
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
