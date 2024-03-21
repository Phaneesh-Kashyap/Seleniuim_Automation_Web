package Selenium_learning;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Z_01_ChildWindow_Handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wait w = new Wait();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		
		Set<String> win = driver.getWindowHandles();
		java.util.Iterator<String> it = win.iterator();
		String parantid = it.next();
//		System.out.println(win.size());
		
		
		for (int i = win.size(); i > 2 ; i--)
		{
			
			String childid = it.next();
			driver.switchTo().window(childid);
			System.out.println("closing tab mnumber : " + i);
			driver.close();
			w.Wait(1000);
			
		}
		
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim());		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split("with")[0].trim());
		String ss = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split("with")[0].trim();
		System.out.println("email id : " + ss);
		
		driver.switchTo().window(parantid);
		driver.findElement(By.id("username")).sendKeys(ss);
		
		
		w.Wait(2000);
		driver.switchTo().window(childid);
		driver.close();
		w.Wait(2000);
		driver.quit();
		
		
	}

}
