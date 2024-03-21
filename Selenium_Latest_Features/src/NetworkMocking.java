import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		
//		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		devtools.addListener(Fetch.requestPaused(), request ->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String newurl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				
				System.out.println(newurl);
				
				devtools.send(Fetch.continueRequest
						( request.getRequestId()
						, Optional.of(newurl)
						, Optional.of(request.getRequest().getMethod())
						, Optional.empty()
						, Optional.empty()
						, Optional.empty()));
				
			}
			
//			response.getResponse().getStatus();
			
		});
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector("button[class*='btn-primary']")).click();
		
		Thread.sleep(3000);
		
		String aa = driver.findElement(By.xpath("//th[text()='1']/following-sibling::td[1]")).getText();
		System.out.println(aa);
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
