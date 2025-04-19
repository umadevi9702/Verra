package About;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OurImpact {
	
	WebDriver driver;	

  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
	  opt.addArguments("--headless=new");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
  }
  
  @Test(priority=1)
  public void A() {
	  driver.get("https://verra.org/");
	  System.out.println("URL Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-15']//a[@class='mega-menu-link'][normalize-space()='About']")).click();
	  System.out.println("About tab clicked");
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-61506']//a[@class='mega-menu-link'][normalize-space()='Our Impact']")).click();
	  System.out.println("Our Impact tab clicked");
	  driver.findElement(By.xpath("//a[@type='button']")).click();
	  System.out.println("Read Case Study button clicked");
	  
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  System.out.println("Page scrolled down");
	  
	  js.executeScript("window.scrollTo(0,0)");
	  System.out.println("Page scrolled up");
  }

  @Test(priority=2)
  public void B() {
	  
	  A();
	  
	  String act_title=driver.getTitle();
	  if(act_title.equals(act_title)) 
	  {System.out.println("Test case: OurImpact-Pass");}
	  else {System.out.println("Test case: OurImpact-Fail");}
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("URL Closed");
  }

}
