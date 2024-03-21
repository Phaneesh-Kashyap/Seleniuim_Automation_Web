import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DhanTest {
	
	@Test
	public void GoogleTst() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
//		caps.setPlatform(Platform.LINUX);//------ OS on which you want to run
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444"), caps);
		driver.get("https://dhanonethree.com/");
		
		
		
		String webTitle = driver.getTitle();
		String URL1 = driver.getCurrentUrl();
		System.out.println("Website Title :" + webTitle);
		System.out.println("Website URL :" + URL1);
		
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	      System.out.println("Number of Links in the Page is " + links.size());
	      
	      for (int i = 1; i<=links.size()-1; i = i+1) 
	      {
	         System.out.println("Name of Link #" + i + " is :- " + links.get(i).getText());
	      }
	      
	      Thread.sleep(5000);
	      
	      driver.quit();
	}

}
