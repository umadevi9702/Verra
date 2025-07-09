package Programs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;

import TheVerra.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JurisdictionalAndNestedREDDPlusFramework {
	
	WebDriver driver;
	TestUtilities utils;	
  @BeforeMethod
  public void beforeMethod() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addArguments("--headless=new");
	  opt.addExtensions(file);
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	  
  }
  
  @Test(priority=1)
  public void A(){
	  
	  driver.get("https://verra.org/");
	  System.out.println("Url Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-16']//a[@class='mega-menu-link'][normalize-space()='Programs']")).click();
	  System.out.println("Programs Dropdown clicked");
	  //Thread.sleep(3000);
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-3592']//a[@class='mega-menu-link'][normalize-space()='Jurisdictional and Nested REDD+ Framework']")).click();
	  System.out.println("Jurisdictional And Nested REDD + Framework clicked");
  }
  
  @Test(priority=2)
  public void B(){
	  
	  A();
	  
	  String act_title=driver.getTitle();
	  System.out.println("Actual Title"+act_title);
	  
	  String expected_title="Jurisdictional & Nested Redd+ Framework - Verra";
	  
	  Assert.assertEquals(act_title, expected_title, "JurisdictionalAndNestedREDDPlusFramework : Fail");

      System.out.println("JurisdictionalAndNestedREDDPlusFramework : Pass");
  }
  
   
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
