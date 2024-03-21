import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.emulation.Emulation;

import com.google.common.collect.ImmutableMap;

public class SetGeoLocation {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
        //SPAIN
//		params.put("latitude", 40);
//        params.put("longitude", 3);
//        params.put("accuracy", 1);
//        
        //GERMANY
//        params.put("latitude", 50);
//        params.put("longitude", 8);
//        params.put("accuracy", 1);
        
        //RUSSIA
        params.put("latitude", 59);
        params.put("longitude", 47);
        params.put("accuracy", 1);
        
        //belakavadi
//        params.put("latitude", 12);
//        params.put("longitude", 77);
//        params.put("accuracy", 1);
//		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", params.build());
		Thread.sleep(1000);
		driver.get("https://google.com");
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("mandya",Keys.ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[normalize-space()='News'])[1]")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[normalize-space()='All'])[1]")).click();
//		Thread.sleep(1000);
		String title = driver.findElements(By.cssSelector("div[class*='n0jPhd']")).get(0).getText();
		Thread.sleep(1000);
		
//		String title = driver.findElement(By.cssSelector("h1[class*='default-ltr-cache']")).getText();
		System.out.println(title);
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}
}
