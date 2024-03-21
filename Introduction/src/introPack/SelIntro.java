package introPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SelIntro {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/phane/Documents/04. Automation - new learning/Selenium/Drivers/Fireforx/geckodriver.exe");
		//FirefoxOptions options = new FirefoxOptions();
		//options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("marionette",true);
		//capabilities.setCapability(FirefoxOptions.CAPABILITY, options);
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("marionette",true);
		//driver= new FirefoxDriver(capabilities);
		//WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), browserDriverOptions);
		//options.setCapability("marionette", false);
        //options.setLogLevel(FirefoxDriverLogLevel.TRACE);
        
		WebDriver driver =  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		//driver.get("https://dhanonethree.com/")
		driver.navigate().to("https://dhanonethree.com/");
		//driver.navigate().to("https://www.guru99.com/");
		 //driver.get("https://www.guru99.com/");
     	 
	     	//Resize current window to the set dimension
	        driver.manage().window().maximize();
		
		String webTitle = driver.getTitle();
		String URL1 = driver.getCurrentUrl();
		System.out.println("Website Title :" + webTitle);
		System.out.println("Website URL :" + URL1);
		
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	      System.out.println("Number of Links in the Page is " + links.size());
	      
	      for (int i = 1; i<=links.size(); i = i+1) {
	         System.out.println("Name of Link# " + i + " - " + links.get(i).getText());
	      }
		 
		 //Commenting driver.quit() for user to easily verify the links
		 //driver.quit();
		
	}

}
