package Projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TheVerra.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerraRegistry {
	
	
	WebDriver driver;
	TestUtilities utils;
	

  @BeforeMethod
  public void beforeMethod() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addArguments("--headless=new");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);	 
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	  
  }
	
  @Test(priority=1)
  public void A() {
	  
	  driver.get("https://verra.org/#");
	  System.out.println("URL Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-17']//a[@class='mega-menu-link'][normalize-space()='Projects']")).click();
      System.out.println("Projects dropdown clicked");
      driver.findElement(By.xpath("//li[@id='mega-menu-item-5511']//a[@aria-label='Verra Registry - open in a new tab'][normalize-space()='Verra Registry']")).click();
      System.out.println("Verra Registry got clicked");     
      
      JavascriptExecutor js=(JavascriptExecutor)driver;
      js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
      System.out.println("Window scrolled down");
      
      js.executeScript("window.scrollTo(0,0)");
      System.out.println("Window scrolled up");
      
  }
     
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("Window closed");
  }

}
