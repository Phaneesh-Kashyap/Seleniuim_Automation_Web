package introPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Open_Chrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.setProperty("webdriver.chrome.driver", "C:/Users/phane/Documents/04. Automation - new learning/Selenium/Drivers/V111/chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.verboseLogging", "true");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		//System.setProperty("webdriver.chrome.whitelistedIps", "");
		//System.setProperty("webdriver.chrome.whitelisted-ips", "");
		/*
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");
		options.addArguments("--headless");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");  
		*/
		WebDriver driver =  new ChromeDriver();
		
		//driver.navigate().to("https://dhanonethree.com/");
		String URL = "https://dhanonethree.com/";
        driver.get(URL);
		
        String webTitle = driver.getTitle();
		String URL1 = driver.getCurrentUrl();
		System.out.println("Website Title :" + webTitle);
		System.out.println("Website URL :" + URL1);
		
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	      System.out.println("Number of Links in the Page is " + links.size());
	      
	      for (int i = 1; i<=links.size(); i = i+1) {
	         System.out.println("Name of Link# " + i + " - " + links.get(i).getText());
	      }
		
	}

}
