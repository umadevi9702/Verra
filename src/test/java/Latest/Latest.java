package Latest;

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

import TheVerra.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Latest {
	
	WebDriver driver;
	TestUtilities utils;	

  @BeforeMethod
  public void beforeMethod() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String [] {"enable-automation"});
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
	  //opt.addArguments("--headless=new");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	  
  }

  @Test
  public void Latesttab() {
	  driver.get("https://verra.org/");
	  System.out.println("URL opened");
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-19']//a[@class='mega-menu-link'][normalize-space()='Latest']")).click();
	  System.out.println("Latest tab clicked");
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-75']//a[@class='mega-menu-link'][normalize-space()='News']")).click();
	  System.out.println("News tab got clicked");
	  
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  System.out.println("Window scrolled down");
	  
	  js.executeScript("window.scrollTo(0,0)");
	  System.out.println("Window scrolled up");
	    
  }  
  

  
  
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("URL Closed");
  }

}
