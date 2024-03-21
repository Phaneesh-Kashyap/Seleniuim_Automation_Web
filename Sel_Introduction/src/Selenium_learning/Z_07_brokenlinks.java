package Selenium_learning;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Z_07_brokenlinks {

	public static void main(String[] args) {
		
		Wait w = new Wait();
		SoftAssert a = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		
		for(WebElement el : ele)
		{	
			String s = el.getAttribute("href");
			
			
			
			try
			{
				HttpURLConnection conn = (HttpURLConnection)new URL(s).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				
				int respCode = conn.getResponseCode();
//				if(respCode>400)
//				{
					//System.out.println(s + " - " + respCode);
					//System.out.println("/n");
					a.assertTrue(respCode<400, "Customer message :: The Link " + s + "is broken.");
					
//				}
			
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
//			catch (MalformedURLException m) 
//			{
//				m.printStackTrace();
//			}
			
			
			
			
			
		}
		
		driver.quit();
		
		a.assertAll();
		
		
		w.Wait();
		
		
		
	}
}
