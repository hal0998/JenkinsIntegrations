package GUI_Testing;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandling {
	
	// https://www.seleniumeasy.com/test/window-popup-modal-demo.html
			// path : /Users/hmuhet/Downloads/chromeDriver/chromedriver
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/hmuhet/Downloads/chromeDriver/chromedriver");
		
	 driver = new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
		
	}
	
	@Test
	public void test() {
		
		driver.findElement(By.xpath("(//a[@class='btn btn-primary followeasy'])[1]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
			
			System.out.println("this is all the window ids \t" + it.next());
		}
		
		
		
	}

}
