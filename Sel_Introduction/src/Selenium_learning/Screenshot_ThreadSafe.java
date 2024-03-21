package Selenium_learning;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;

public class Screenshot_ThreadSafe {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Wait w = new Wait();
			ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
			driver.set(ThreadGuard.protect(new ChromeDriver()));
			
			
//			WebDriver driver = new ChromeDriver();
			driver.get().manage().window().maximize();
			driver.get().get("https://rahulshettyacademy.com/dropdownsPractise/");

			w.Wait();
			System.out.println(driver.get().getTitle());
			System.out.println(driver.get().getCurrentUrl());

			int a = 5;
			getscreenshot(driver.get());

		}

		public static void getscreenshot(WebDriver driver) {
//			driver.get("http://google.com");

			try {

				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
//				WebDriver augmentedDriver = new Augmenter().augment(driver);
//			    File src = ((TakesScreenshot)augmentedDriver).
//			                        getScreenshotAs(OutputType.FILE);
				
				
//			FileUtils.copyFile(src,new File("C:\\Users\\phane\\Documents\\04. Automation - new learning\\Selenium\\Screenshots\screenshot1.png"));
//			File DestFile=new File("C:\\Users\\phane\\Documents\\04. Automation - new learning\\Selenium\\Screenshots\screenshot1.png");
//			FileHandler.copy(src, DestFile);

				FileUtils.copyFile(src, new File(
						"C:\\Users\\phane\\Documents\\04. Automation - new learning\\Selenium\\Screenshots\\screenshot2.png"));

			} catch (IOException e) {
				e.printStackTrace();
			}

//			FileHandler.copy(src,new File("C:\\Users\\phane\\Documents\\04. Automation - new learning\\Selenium\\Screenshots\screenshot1.png"));
//			FileHandler.copy(src, src)

		}

}
