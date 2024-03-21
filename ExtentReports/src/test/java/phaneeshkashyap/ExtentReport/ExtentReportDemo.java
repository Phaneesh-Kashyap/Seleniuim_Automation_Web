package phaneeshkashyap.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
	ExtentTest test;
	
	
	@BeforeTest
	public void config()
	{
//		Classes ==> ExtentReports & ExtentSparkReporter
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("TEST RESULTS");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Phaneesh");
		
//		test = extent.createTest("initialDemo");
		
	}
	
	
	@Test
	public void initialDemo()
	{
		test = extent.createTest("TestinitialDemo");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
//		test.addScreenCaptureFromBase64String(s);
		test.pass("Result Do match");
		test.fail("Result Do not match");
		test.pass("Result Do match");
		
		driver.quit();
		extent.flush();
		
		
	}
	
	

	@Test
	public void initialDemo1()
	{
		test = extent.createTest("TestinitialDemo1");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		test.pass("Result Do match");
		driver.quit();
		extent.flush();
		
		
	}
	
	
	@Test
	public void initialDemo2() throws InterruptedException
	{
		ExtentTest test = extent.createTest("TestinitialDemo2");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		test.pass("Result Do match");
		Thread.sleep(5000);
		driver.quit();
		extent.flush();
		
		
	}
	
	
	
}
