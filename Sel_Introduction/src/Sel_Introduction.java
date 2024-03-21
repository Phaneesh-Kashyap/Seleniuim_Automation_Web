import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Introduction {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/phane/Documents/04. Automation - new learning/Selenium/Drivers/V113/chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver1 = new ChromeDriver();
		
		driver.get("https://dhanonethree.com/");
		
		var x = driver.getTitle();
		System.out.println(driver.getTitle());
		
		//var myLink = driver.findElement(By.name("CONTACT"));
		//myLink.click();
	
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		//driver.quit();
		
	}
}
