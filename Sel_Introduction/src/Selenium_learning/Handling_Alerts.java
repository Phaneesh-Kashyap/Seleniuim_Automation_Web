package Selenium_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverFinder;

public class Handling_Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Wait w = new Wait();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String text = "Phaneesh";
		
		driver.findElement(By.id("name")).sendKeys(text);
		w.Wait();
		//alertbtn
		driver.findElement(By.id("alertbtn")).click();
		w.Wait();
		System.out.println(driver.switchTo().alert().getText());
		w.Wait();
		driver.switchTo().alert().accept();
		
		w.Wait();
		//alertbtn
		driver.findElement(By.id("alertbtn")).click();
		w.Wait();
		driver.switchTo().alert().dismiss();
		w.Wait();
		
		
		//confirmbtn
		driver.findElement(By.id("confirmbtn")).click();
		w.Wait();
		driver.switchTo().alert().accept();
		w.Wait();
		
		driver.findElement(By.id("confirmbtn")).click();
		w.Wait();
		driver.switchTo().alert().dismiss();
		w.Wait();
		
		
		
		
		w.Wait();
		w.Wait();
		w.Wait();
		w.Wait();
		
		driver.quit();
		
		
		
	}

}
