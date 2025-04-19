package Projects;

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

public class RegistryOverview {
	  WebDriver driver;
	  
  @BeforeMethod
  public void beforeMethod() {	
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addArguments("--headless=new");
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
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
	  System.out.println("Projects tab clicked");
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-3566']//a[@class='mega-menu-link'][normalize-space()='Registry Overview']")).click();
	  System.out.println("Registry Overview clicked");
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  System.out.println("Page Scrolled down");
	  
	  js.executeScript("window.scrollTo(0,0)");
	  System.out.println("Page Scrolled up");
  }

  
  @Test(priority=2)
  public void B() {
	  
	  A();
	  String act_title=driver.getTitle();
	  if(act_title.equals(act_title)) 
	  {
		  System.out.println("Registry Overview: Passed");
	  }
	  else 
	  {
		  System.out.println("Registry Overview: Failed");
	  }
		  
  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	 
	  driver.quit();
	  System.out.println("URL Closed");
	 
  }

}
