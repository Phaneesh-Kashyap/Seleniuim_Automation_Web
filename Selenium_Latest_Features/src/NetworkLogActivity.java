import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.network.Network;

import com.google.common.collect.ImmutableMap;

public class NetworkLogActivity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
//		devtools.addListener(Network.requestWillBeSent(), request ->
//		{
//			System.out.println(request.getRequest().getUrl());
//			System.out.println(request.getRequest().getHasPostData());
////			response.getResponse().getStatus();
//			
//		});
		
		
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		devtools.addListener(Network.responseReceived(), response ->
		{
			System.out.println(response.getResponse().getUrl());
			System.out.println(response.getResponse().getStatus());
//			response.getResponse().getStatus();
			
		});
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button[class*='btn-primary']")).click();
		
		
//		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
//		Thread.sleep(1000);
		
//		driver.findElement(By.linkText("Library")).click();
//		Network.getRequestPostData(requestID);
//		Thread.sleep(1000);
		
//		
		devtools.addListener(Network.responseReceived(), response ->
		{
			System.out.println(response.getResponse().getUrl());
			System.out.println(response.getResponse().getStatus());
//			response.getResponse().getStatus();
			
		});
//		
		
//		String aa = driver.findElement(By.xpath("//th[text()='1']/following-sibling::td[1]")).getText();
//		System.out.println(aa);
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
