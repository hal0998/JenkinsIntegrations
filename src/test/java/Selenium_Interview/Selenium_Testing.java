package Selenium_Interview;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Selenium_Testing {

	WebDriver driver;

	@BeforeMethod
	public void Set_Up() {

		System.setProperty("webdriver.chrome.driver", "/Users/hmuhet/Downloads/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		long hight = driver.manage().window().getSize().getHeight();
		long width = driver.manage().window().getSize().getWidth();
		System.out.println("The Window Hight is : " + hight + " width is : " + width);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.testim.io/");

	}

	@Test
	public void Get_window_Handles() throws Exception {

		long hight = driver.manage().window().getSize().getHeight();
		long width = driver.manage().window().getSize().getWidth();
		System.out.println("The Window size after maximize, Height is : " + hight + " width is : " + width);

		driver.findElement(By.xpath("//a[text()='Get automate free']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Get automate free']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Get automate free']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Get automate free']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Get automate free']")).click();
		Thread.sleep(1000);

		String parent = driver.getWindowHandle();
		Set<String> windowSet = driver.getWindowHandles();

		if (windowSet.size() > 1) {

			System.out.println("The window size is : " + windowSet.size());
			for (String id : windowSet) {

				if (!id.equalsIgnoreCase(parent)) {

					driver.switchTo().window(id).close();

				}
			}

			String ifparent = driver.switchTo().window(parent).getWindowHandle();

			if (ifparent.equalsIgnoreCase(parent)) {

				System.out.println("Successfully Go Back To the Parent Window!");
				driver.quit();

			}
		}

	}

}
