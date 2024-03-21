import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class StaticDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
				Wait w = new Wait();
		
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
				w.Wait();
				
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				
				// Static dropdown with select tag
				
				WebElement aDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				Select dd = new Select(aDropdown);
				dd.selectByIndex(3);
				System.out.println(dd.getFirstSelectedOption().getText());
//				w.Wait();
				
				dd.selectByValue("AED");
				System.out.println(dd.getFirstSelectedOption().getText());
//				w.Wait();
				
				dd.selectByVisibleText("INR");
				System.out.println("selected currency : " + dd.getFirstSelectedOption().getText());
				
				w.Wait();

				///// dynamic dropdown ---------------------------------
				
				driver.findElement(By.id("divpaxinfo")).click();
				w.Wait();
				
				int i=1;
				while(i<3)
				{
					driver.findElement(By.id("hrefIncAdt")).click();
					i++;
				}
				
				for(int j=1; j<2 ; j++){driver.findElement(By.id("hrefIncChd")).click();}
				w.Wait();
				
				driver.findElement(By.id("btnclosepaxoption")).click();
				driver.findElement(By.id("divpaxinfo")).getText();
				
				System.out.println("selected options : " + driver.findElement(By.id("divpaxinfo")).getText());
				
				
				
				w.Wait();
				
				
				
				
				w.Wait();
				w.Wait();
				driver.quit();
				
		
	}

}
