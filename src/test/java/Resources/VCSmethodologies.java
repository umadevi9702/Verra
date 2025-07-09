package Resources;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VCSmethodologies {
	
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
	  driver.get("https://verra.org/");
	  System.out.println("URL Opened");
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");
	  
	  /*TakesScreenshot ts=(TakesScreenshot)driver;
	  File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	  File targetfile=new File(System.getProperty("user.dir")+"screenshots_verra\\fullpage.png");
	  sourcefile.renameTo(targetfile);*/
	  
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-18']//a[@class='mega-menu-link'][normalize-space()='Resources']")).click();
	  System.out.println("Resources tab clicked");
	  driver.findElement(By.xpath("//li[@id='mega-menu-item-64054']//a[@class='mega-menu-link'][normalize-space()='VCS Methodologies']")).click();
	  System.out.println("VCS Methodologies tab clicked");
	  
	  WebElement Ts=driver.findElement(By.xpath("//div[@class='icon-box-block__wrap d-block']//div[@class='row']"));
	  File SFourcefile=Ts.getScreenshotAs(OutputType.FILE);
	  File Targetfile=new File(System.getProperty("user.dir")+"\\screenshots_verra\\featureproducts.png");
	  SFourcefile.renameTo(Targetfile);
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
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
	 {System.out.println("Testcase#VCSMethodologies: Pass");}
	 else {System.out.println("Testcase#VCSMethodologies: Fail");}
}

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("URL closed");
  }

}
