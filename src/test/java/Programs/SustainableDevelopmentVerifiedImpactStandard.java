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

public class SustainableDevelopmentVerifiedImpactStandard {
	
	WebDriver driver;
	TestUtilities utils;
 
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addExtensions(file);
	  //opt.addArguments("--headless=new");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  
  @Test(priority=1)
  public void A() throws InterruptedException {
	  
	  driver.get("https://verra.org/");
	  System.out.println("URL Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window Maximized");
	  //driver.switchTo().frame(0);
	  driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
	  System.out.println("Cybot Cookiebot DialogBodyLevel ButtonLevelOptin AllowAll");
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-16']//a[@class='mega-menu-link'][normalize-space()='Programs']")).click();
	  System.out.println("Programs tab clicked");
	  //Thread.sleep(3000);
	  driver.findElement(By.cssSelector("li[id='mega-menu-item-3602'] a[class='mega-menu-link']")).click();
	  System.out.println("Sustainable Development Verified ImpactStandard got clicked ");
	 
	  
  }
  
 @Test(priority=2)
  public void B() throws InterruptedException {
	  
	  A();
	  
	  String act_title=driver.getTitle();
	  System.out.println("Actualtitle:"+act_title);
	  
	  String exp_title="Sustainable Development Verified Impact Standard - Verra";
	  if(exp_title.equals(exp_title)) {
		  
		  System.out.println("SustainableDevelopmentVerifiedImpactStandardTest :Pass");
	  }
	  else {
		  System.out.println("SustainableDevelopmentVerifiedImpactStandardTest :Fail");
	  }
	  
	
  }
	  

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
	  System.out.println("URL closed");
  }

}
