import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.fetch.Fetch;
import org.openqa.selenium.devtools.v112.fetch.model.RequestPattern;

public class NetworkFailRequest {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
//		java.util.Optional<java.lang.String> urlPattern, 
//		java.util.Optional<org.openqa.selenium.devtools.v112.network.model.ResourceType> resourceType
//		java.util.Optional<org.openqa.selenium.devtools.v112.fetch.model.RequestStage> requestStage
		new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty());
		
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		
	}
}
