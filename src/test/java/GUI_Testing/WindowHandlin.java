package GUI_Testing;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlin {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.testim.io/");

	}

	@Test
	public void windowTest() throws Exception {

		driver.findElement(By.xpath("//main[@id='main']/section/div/div/div/div/a[1]")).click();
		driver.findElement(By.xpath("//main[@id='main']/section/div/div/div/div/a[1]")).click();
		driver.findElement(By.xpath("//main[@id='main']/section/div/div/div/div/a[1]")).click();

		Set<String> window = driver.getWindowHandles();
		String id = driver.getWindowHandle();

		Iterator<String> it = window.iterator();
		String window1 = it.next();

		while (it.hasNext()) {
			Thread.sleep(2000);
			String winId = it.next();
			if (!id.equalsIgnoreCase(winId)) {

				driver.switchTo().window(winId).close();
				// driver.close();

			}

		}

	}

}

@FunctionalInterface
interface name {

	public void first_name();

}
