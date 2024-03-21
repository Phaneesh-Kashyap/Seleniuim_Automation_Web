package Selenium_learning;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Z_06_SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions op = new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		
		
		Wait w = new Wait();
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
//		driver.manage().addCookie(null);
//		driver.manage().deleteCookieNamed("sessionkey");
		
		
		driver.get("https://google.co.in/");
		
		
		System.out.println(driver.getTitle());
		
		try
		{
		
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:/test/some_screenshot.png"));
		

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		
		w.Wait(5000);
		driver.quit();
		
		
	}

}
