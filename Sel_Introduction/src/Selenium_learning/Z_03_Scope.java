package Selenium_learning;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Z_03_Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Wait w = new Wait();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//print each link in the page
		///reduce scope of driver and print the links
		/// check if the links are working fine??
		/// click on links and get the window titles
		
		
		List<WebElement> ww = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links in this page : " + ww.size());
		
		w.Wait(1000);
		
		
		for(WebElement ele : ww)
		{
			System.out.println(ele.getAttribute("href"));
		}
		
		w.Wait(1000);
		
		
		System.out.println("----------------------------------------------");
		w.Wait(1000);
		
		//gf-BIG		
		WebElement subdriver = driver.findElement(By.id("gf-BIG"));
		
		List<WebElement> www = subdriver.findElements(By.tagName("a"));
		
		System.out.println("Number of links in this page : " + www.size());
		
		w.Wait(1000);
		
		
		for(WebElement ele : www)
		{
			System.out.println(ele.getAttribute("href"));
		}	
		
		w.Wait(1000);
		
		System.out.println("----------------------------------------------");
		w.Wait(1000);
		
		WebElement ssDriver = subdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		List<WebElement> wwww = ssDriver.findElements(By.tagName("a"));
		
		System.out.println("Number of links in this page : " + wwww.size());
		
		w.Wait(1000);
		
		/// check if the links are working fine??
		
		for(WebElement ele : wwww)
		{
			System.out.println(ele.getAttribute("href"));
			String openact = Keys.chord(Keys.CONTROL,Keys.ENTER);

			ele.sendKeys(openact);
//			w.Wait(2000);
//			driver.navigate().back();
//			w.Wait(2000);
			
		}	
		
		w.Wait(1000);
		System.out.println("----------------------------------------------");
		w.Wait(5000);
		
		
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String parantid = it.next();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			w.Wait(1000);
			driver.close();
		}
		driver.switchTo().window(parantid);
		
		
		/// assignement
		
		WebElement el = driver.findElement(By.id("checkBoxOption2"));
		el.click();
		String ss = el.getAttribute("value");
		
		
		WebElement dd = driver.findElement(By.id("dropdown-class-example"));
		Select dr = new Select(dd);
		dr.selectByValue(ss);
		
		
		driver.findElement(By.id("name")).sendKeys(ss);
		
		
		driver.findElement(By.id("alertbtn")).click();
		
		
		if(driver.switchTo().alert().getText().contains(ss))
		{
			System.out.println("--------- Test Passed-------------");
		}
		
		
		
		
		w.Wait(2000);
		w.Wait(2000);
		driver.quit();
		
		
		
	}

}
