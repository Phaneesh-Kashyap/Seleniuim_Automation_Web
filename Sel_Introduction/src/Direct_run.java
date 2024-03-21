import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Direct_run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//it downloads the Selenium manager directly and runs
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		// dropdown with select tag
		
		
	}

}
