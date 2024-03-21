import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.emulation.Emulation;

public class MobileTestEmulator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver","C:\\Users\\phane\\Documents\\04. Automation - new learning\\Selenium\\Drivers\\V114\\chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		//send commands to CDP methods -> invoke the methods 
		devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 68, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty()));
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
//		Network.getRequestPostData(requestID);
		Thread.sleep(2000);
		String aa = driver.findElement(By.xpath("//th[text()='1']/following-sibling::td[1]")).getText();
		System.out.println(aa);
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
