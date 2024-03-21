package Selenium_learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException e) {
		    System.out.println("got interrupted!");
		}
		
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.id("checkBoxOption3")).click();
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {
		    System.out.println("got interrupted!");
		}
		
		SoftAssert a = new SoftAssert();
		
		
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException e) {
		    System.out.println("got interrupted!");
		}
		
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		
		List<WebElement> cbs = driver.findElements(By.cssSelector("input[type='checkbox']"));
		
		System.out.println("No. of checkboxes : " + cbs.size());
		
	}

}
