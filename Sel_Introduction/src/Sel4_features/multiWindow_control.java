package Sel4_features;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import Selenium_learning.Wait;

public class multiWindow_control {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Wait w = new Wait();
		SoftAssert a = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> ww = driver.getWindowHandles();
		Iterator<String> it = ww.iterator();
		String parantw = it.next();
		String childw = it.next();
		
		driver.switchTo().window(childw);
		driver.get("https://rahulshettyacademy.com/");
		
		String ss = driver.findElement(By.xpath("//a[contains(text(),'Cypress')]")).getText();
		w.Wait();
		
		driver.switchTo().window(parantw);
		
		WebElement name =driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']"));
		
		name.sendKeys(ss);
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\phane\\Documents\\04. Automation - new learning\\Selenium\\Screenshots\\sc2.png"));
		
//		WebElement name1 = driver.findElement(By.cssSelector("form[class='ng-pristine ng-invalid ng-touched']"));
//		File src1 = name1.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src1, new File("C:\\Users\\phane\\Documents\\04. Automation - new learning\\Selenium\\Screenshots\\sc3.png"));
		
		
//		name.getRect().getDimension().getHeight()
		System.out.println(name.getRect().getDimension());
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getWidth());
		System.out.println(name.getRect().getX());
		System.out.println(name.getRect().getY());
		
		
		w.Wait(5000);
		driver.quit();
		
		
		
	}

}
