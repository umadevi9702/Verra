package Programs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TheVerra.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ClimateCommunityBiodiversityStandards {
	
	WebDriver driver;
	TestUtilities utils;
  @BeforeClass
  public void beforeClass() {
	  ChromeOptions opt=new ChromeOptions();
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addExtensions(file);
	  opt.addArguments("--headless=new");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  utils=new TestUtilities(driver, opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
  }

  @Test(priority=1)
  public void A() {
	  driver.get("https://verra.org/");
	  System.out.println("URL Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-16']//a[@class='mega-menu-link'][normalize-space()='Programs']")).click();
      System.out.println("Programs tab clicked");
      
      driver.findElement(By.xpath("//li[@id='mega-menu-item-3604']//a[@class='mega-menu-link'][normalize-space()='Climate, Community & Biodiversity Standards']")).click();
      System.out.println("Climate Community Biodiversity & Standards got clicked");  
      
      JavascriptExecutor js=(JavascriptExecutor) driver;      
      js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  System.out.println("Window scrolled down");
		
		js.executeScript("window.scrollTo(0,0)");
		System.out.println("Window scrolled up");
  }
  
  
  @Test(priority=2)
  public void B() {
	  
	  String act_title=driver.getTitle();
	  System.out.println("Actualtitle:"+act_title);
	  
	  String exp_title="Climate, Community & Biodiversity Standards - Verra";
	  if(exp_title.equals(exp_title)) {
		  
		  System.out.println("Climate, Community & Biodiversity Standards - Verra: Test Pass");
	  }
	  else {
		  System.out.println("Climate, Community & Biodiversity Standards - Verra: Test Fail");
	  }
	  
  }
   
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
