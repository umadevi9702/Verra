import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class SetupDockerGrid {

  @SuppressWarnings("deprecation")
@BeforeTest
  void beforeTest() throws InterruptedException, IOException {
	  
	  Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
	  Thread.sleep(15000);
  }
  
  /*@Test-Verra
  public void f() {
  }*/

  @SuppressWarnings("deprecation")
@AfterTest
  void afterTest() throws IOException, InterruptedException {
	  Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
	  Thread.sleep(15000);
	  Runtime.getRuntime().exec("taskkill / f /im cmd.exe");
	  //taskkill /f /im cmd.exe
  }

}
