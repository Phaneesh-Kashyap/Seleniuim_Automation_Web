package Selenium_learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Z_02_Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Wait w = new Wait();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		
		///switch to frame
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		driver.findElement(By.id("draggable")).click();
		
		Actions a = new Actions(driver);
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(src, dest).build().perform();
		
		if(driver.findElement(By.cssSelector(".ui-state-highlight")).isDisplayed())
		{
			System.out.println("object dragged and dropped!!!");
		}
		else
		{
			System.out.println("object not dragged and dropped!!!");
		}
		
		w.Wait(2000);
		
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		driver.switchTo().frame(0);
		
		if(driver.findElements(By.cssSelector(".ui-state-highlight")).size() != 0)
		{
			System.out.println("object dragged and dropped!!!");
		}
		else
		{
			System.out.println("object not dragged and dropped!!!");
		}
		
		w.Wait(2000);
		
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		
		if(driver.findElement(By.cssSelector(".logo")).isDisplayed())
		{
			System.out.println("We are outside frames!!!");
		}
		
		w.Wait(2000);
		
		driver.quit();
		
	}

}
