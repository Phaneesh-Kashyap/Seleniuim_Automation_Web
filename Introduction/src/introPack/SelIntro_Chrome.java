package introPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntro_Chrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step 1 :: Invoking browser (chrome) with Chrome driver
		// here -> we can use methods available in chromedriver which are unique to itself
		// cross browser testing not attained.
		//ChromeDriver driver =  new ChromeDriver();
				
		//invoking chrome driver -- manually -- Chromedriver.exe
		// automation - webdriver.chrome.driver -> will pick the path from where the chrome can be invoked
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/phane/Documents/04. Automation - new learning/Selenium/Drivers/V111/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:/Users/phane/Documents/04. Automation - new learning/Selenium/Drivers/Fireforx/geckodriver.exe");
		
		// to do cross browser testing
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		//WebDriverManager.chromedriver().browserVersion("111.0.5563.64").setup();
		//WebDriver driver =  new ChromeDriver();
		//WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		//ChromeOptions options = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		//options.addArguments("--whitelisted-ips=\"\"");
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		System.setProperty("webdriver.chrome.whitelisted-ips", "");
		
		options.addArguments("--disable-web-security");
		options.addArguments("--headless");

		options.addArguments("--disable-notifications");

		options.addArguments("--disable-gpu");

		options.addArguments("--disable-extensions");

		options.addArguments("--no-sandbox");

		options.addArguments("--disable-dev-shm-usage");

		options.addArguments("--remote-allow-origins=*");  
		
		//DesiredCapabilities capabilities = new DesiredCapabilities();

		//capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		//options.merge(capabilities);

		//wd = new ChromeDriver(options);

		//wd.manage().window().maximize();
		
		WebDriver driver =  new ChromeDriver(options);
		//WebDriver driver =  new FirefoxDriver();
		
		//driver.navigate().to("http://www.google.com")
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		//driver.get("https://www.youtube.com");
		String URL = "http://www.google.com/";
        //WebDriver driver = new ChromeDriver();
        driver.get(URL);
		//driver.get("https://www.youtube.com");
		//System.out.println(driver.getTitle());
		
	}

}
