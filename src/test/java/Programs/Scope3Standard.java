package Programs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TheVerra.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope3Standard {
	
	WebDriver driver;
	TestUtilities utils;	

  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions opt=new ChromeOptions();
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addExtensions(file);
	  opt.addArguments("--headless=new");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://verra.org/");
	  System.out.println("Url Opened: "+driver.getTitle());
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");	  
  }

  @Test(priority=1)
  public void A() {
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-16']//a[@class='mega-menu-link'][normalize-space()='Programs']")).click();
	  System.out.println("Programs dropdown clicked");
	  driver.findElement(By.xpath("//a[@class='mega-menu-link'][normalize-space()='Scope 3 Standard']")).click();
	  System.out.println("Scope 3 Standard got clicked");
  }
  
  @Test(priority=2)
  public void B() {
	  
	  String act_title=driver.getTitle();
	  System.out.println("Actual Title:"+act_title);
	  String exp_title="Scope 3 Standard Program | Verra";
	  
	  if(exp_title.equals(exp_title)) {
		  System.out.println("Test #Scope 3 Standard: Pass");
	  }
	  else {
		  System.out.println("Test #Scope 3 Standard: Fail");
	  }
  }
    
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("URL closed");
  }

}
