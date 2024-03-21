import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import com.google.common.collect.ImmutableMap;

public class CDPCommandTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
        params.put("width", 600);
        params.put("height", 1000);
        params.put("deviceScaleFactor", 68);
        params.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", params.build());
		
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