package Contact;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactTab {
	
	WebDriver driver;
		
  @Test(priority=1)
  public void A() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addArguments("--headless=new");
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get("https://verra.org/");
	  System.out.println("URL Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window Maximized");
	  
	  driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
	  System.out.println("Automessage cliked");
	  
	  driver.findElement(By.cssSelector("li[id='menu-item-21'] a")).click();
	  System.out.println("Contact Tab Clicked");
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  System.out.println("Scrolled down");
	  js.executeScript("window.scrollTo(0,0)");
	  System.out.println("Scrolled up");
	  
	  String act_title=driver.getTitle();
	  if(act_title.equals(act_title))
	  {
		  System.out.println("Test Pass");
	  }
	  else 
	  {
		  System.out.println("Test Fail");
	  }
	  
	 driver.quit();
	 System.out.println("URL Closed");
	 	  
  }
}
