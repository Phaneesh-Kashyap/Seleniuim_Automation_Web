package phaneeshkashyap.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import phaneeshkashyap.AbstractComponents.Wait;
import phaneeshkashyap.pageobjectmodel.LandingPage;

public class BaseClass {

	public WebDriver driver;
//	protected final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//	ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	public LandingPage l; 
	Wait w = new Wait();
	
	public WebDriver initDriver() throws IOException
	{
		
		
		
		w.Wait(2000);
		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream("\\Users\\phane\\Documents\\04. Automation - new learning\\Selenium\\Projects\\SeleniumFrameworkDesign\\src\\main\\java\\phaneeshkashyap\\resources\\GlobalData.properties");
//		String s = System.getProperty("user.dir");
		
//		BasicConfigurator.configure();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") 
				+ "\\src\\main\\java\\phaneeshkashyap\\resources\\GlobalData.properties");
		
		
		prop.load(fis);
		
		
		 
		String brwserName = System.getProperty("broswer")!=null ? 
							System.getProperty("broswer") :
							prop.getProperty("broswer");
		
				
		if(brwserName.toLowerCase().contains("chrome"))
		{	
			ChromeOptions Options = new ChromeOptions();
			if (brwserName.toLowerCase().contains("headless")){Options.addArguments("headless");}
			
			WebDriverManager.chromedriver().setup();
//			driver.set(ThreadGuard.protect(new ChromeDriver()));
//			driver.set((new ChromeDriver()));
			driver = new ChromeDriver(Options);
		}
		else if(brwserName.equalsIgnoreCase("edge"))
		{
//			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "C://EdgeDriver.exe");
			driver = new EdgeDriver();			
		}
		else if(brwserName.equalsIgnoreCase("firefox"))
		{
//			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\phane\\Documents\\"
			+ "04. Automation - new learning\\Selenium\\Drivers\\Fireforx\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
//		threadLocalDriver.set(driver);
		
//		driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.get().manage().window().maximize();
//		return driver.get();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
		
		//Global Properties set up to run in multiple browsers
		//Lets says Firefox
		
	}
	
	public WebDriver getDriver()
	{
//		return driver.get();
		return driver;
	}
	
	
//	
//	public void launchApp() throws IOException
//	{
//		driver = initDriver();
//		LandingPage l = new LandingPage(driver);
//		l.goTo("https://rahulshettyacademy.com/client/");
//		
//	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException
	{
		//read JSON to String
		String jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\"+path),
				StandardCharsets.UTF_8);
		
		//String to Hashamp ==> Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data 
		= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
		
		
	}
	
	
	public synchronized String getScreenshot(String testCaseName, WebDriver driver1) throws IOException
	{
//		WebDriver dd = driver.get();
//		TakesScreenshot ts = ((TakesScreenshot) dd);
//		File src = ts.getScreenshotAs(OutputType.FILE);
		File src = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);

//		testCaseName = System.getProperty()
		String path = System.getProperty("user.dir")+"//reports//"+ testCaseName + ".png";
		
		FileUtils.copyFile(src, new File(path));
		return path;
		
	}
	

	
	@BeforeMethod(alwaysRun=true)
	public LandingPage LaunchApp() throws IOException
	{
		WebDriver driver = initDriver();
		l = new LandingPage(driver);
		l.goTo();
		
		return l;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void teadDown()
	{
		w.Wait(3000);
//		driver.get().quit();
//		driver.remove();
		
		driver.quit();
		
//		threadLocalDriver.remove();
		
	}
	
}
