package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pre_Condition {

	public static WebDriver driver;

	public static String read_Pro(String key) {

		String filePath = System.getProperty("user.dir") + File.separator + "Configuration" + File.separator
				+ "Config.properties";
		Properties pro = new Properties();
		try {

			FileInputStream file = new FileInputStream(filePath);
			pro.load(file);

		} catch (Exception e) {
			System.out.println("The Current File Path is " + filePath);
		}

		return pro.getProperty(key);

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println(System.getProperty("user.dir") + File.separator +
	 * "Configuration" + File.separator + "Config.properties");
	 * System.out.println(Pre_Condition.read_Pro("url"));
	 * System.out.println(Pre_Condition.read_Pro("silenceMode"));
	 * Pre_Condition.browser(); }
	 */
	public static void browser() {

		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "/Users/hmuhet/Downloads/chromeDriver/chromedriver");
//		WebDriver driver = new ChromeDriver();

		String silentMode = Pre_Condition.read_Pro("silenceMode").replaceAll(" ", "");
		System.out.println(silentMode);

		try {
			if (silentMode.equalsIgnoreCase("yes")) {
				driver = new ChromeDriver(new ChromeOptions().addArguments("--headless", "--window-size=1920,1080"));
				System.out.println("Chrome Headless Mode Activated!");
			} else if (silentMode.equalsIgnoreCase("no")) {
				driver = new ChromeDriver();
				System.out.println("Chrome Browser Launched!");
			}
			driver.get(Pre_Condition.read_Pro("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("Please Set Up WebDriver!");
		}

	}

	public static void Kill_Browser() {

		driver.quit();
	
	}

}
