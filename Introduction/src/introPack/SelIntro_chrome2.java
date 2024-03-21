package introPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelIntro_chrome2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/phane/Documents/04. Automation - new learning/Selenium/Drivers/V111/chromedriver.exe");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		System.setProperty("webdriver.chrome.whitelisted-ips", "");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");
		options.addArguments("--headless");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");  
		
		WebDriver driver =  new ChromeDriver(options);
		
		//String URL = "http://www.google.com/";
        //driver.get(URL);
		
	}
	
}
