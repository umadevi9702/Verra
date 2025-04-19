package Programs;

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

public class PlasticWasteReductionStandard {
	
	WebDriver driver;
	TestUtilities utils;	

  @BeforeMethod
  public void beforeMethod() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addExtensions(file);
	 // opt.addArguments("--headless=new");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  
  @Test(priority=1)
  public void A() {
	  
	  driver.get("https://verra.org/");
	  System.out.println("URL Opened:"+driver.getTitle());
	  driver.manage().window().maximize();
	  System.out.println("Window Maximized");
  }
  
  @Test(priority=2)
  public void B() {
	  
	 A();
	  driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
	  System.out.println("Cybot Cookiebot DialogBodyLevel ButtonLevelOptin AllowAll");
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-16']//a[@class='mega-menu-link'][normalize-space()='Programs']")).click();
	  System.out.println("Programs tab clicked");
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-3603']//a[@class='mega-menu-link'][normalize-space()='Plastic Waste Reduction Standard']")).click();
	  System.out.println("Plastic Waster Reduction Standard clicked from the dropdown");
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  System.out.println("Widnow scrolled down");
	  
	  js.executeScript("window.scrollTo(0,0)");
	  System.out.println("Window Scrolled up"); 
	  
  }
  
  @Test(priority=3)
  public void C() {
	  
	  B();
	  
	 String act_title=driver.getTitle();
	 System.out.println("actualtitle:" +act_title);
	 String exp_title="Plastic Waste Reduction Standard - Verra";
	 if(exp_title.equals(exp_title)) {
		 System.out.println("Plastic Waste Reduction Standard: Pass");
	 }
	 else {
		 
		 System.out.println("Plastic Waste Reduction Standard: Fail");
		 
	 }
		 
	  
  }
 
  
  
  
  
  
  
  
  
  
 @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
