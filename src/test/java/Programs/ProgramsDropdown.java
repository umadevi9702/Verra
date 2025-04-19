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

public class ProgramsDropdown {
	
	WebDriver driver;
	TestUtilities utils;	

  @BeforeMethod
  public void beforeMethod() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addArguments("--headless=new");
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  utils=new TestUtilities(driver, opt);  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
  
  @Test(priority=1)
  public void A() throws InterruptedException {
	  
	  driver.get("https://verra.org/");
	  System.out.println("URL Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-16']//a[@class='mega-menu-link'][normalize-space()='Programs']")).click();
	  System.out.println("Programs tab clicked on Verra navbar");
	  Thread.sleep(3000);
  }

  @Test(priority=2)
  public void B() throws InterruptedException {
	  
	  A();
	  String act_title=driver.getTitle();
	  if(act_title.equals(act_title)) {
		  System.out.println("#Programs Tab Test :Passed");
	  }
	  else {
		  System.out.println("#Programs Tab Test :Failed");
	  } 
	  
  } 
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
