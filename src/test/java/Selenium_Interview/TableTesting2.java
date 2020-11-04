package Selenium_Interview;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;
import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class TableTesting2 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/hmuhet/Downloads/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://qa3.vytrack.com/user/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
		Thread.sleep(2000);
		driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
		Thread.sleep(2000);
		driver.findElement(By.id("_submit")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TableTest() throws InterruptedException {

		Actions action = new Actions(driver);
		Thread.sleep(2000);

		action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Customers')])[1]")))
				.moveToElement(driver.findElement(By.xpath("//span[text()='Contacts']"))).click().build().perform();

		Thread.sleep(2000);
		int size = driver.findElements(By.xpath("//tbody[@class='grid-body']/tr")).size();
		System.out.println("The Whole table Size is : " + size);

		boolean editButton = false;

		for (int row = 1; row < size; row++) {

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@class='grid-body']/tr[" + row + "]/td[4]")).click();
			Thread.sleep(2000);

			try {

				editButton = driver.findElement(By.xpath("//i[text()='Edit']")).isDisplayed();
				if (editButton) {
					System.out.println("The " + row + " Customer address information is exist!");
					driver.findElement(By.xpath("(//i[@class='fa-pencil-square-o hide-text'])[2]")).click();
					Thread.sleep(1000);

					WebElement firstName = driver
							.findElement(By.xpath("//input[@name='oro_contact_address_form[firstName]']"));
					firstName.clear();
					firstName.sendKeys(new Faker().name().firstName());

					WebElement lastName = driver
							.findElement(By.xpath("//input[@name='oro_contact_address_form[lastName]']"));
					lastName.clear();
					lastName.sendKeys(new Faker().name().lastName());

					WebElement comapany = driver
							.findElement(By.xpath("//input[@name='oro_contact_address_form[organization]']"));
					comapany.clear();
					comapany.sendKeys(new Faker().company().name());

					Select dropDown1 = new Select(
							driver.findElement(By.xpath("//select[@name='oro_contact_address_form[country]']")));
					Thread.sleep(1000);
					dropDown1.selectByVisibleText(new Faker().country().name());

					WebElement address = driver
							.findElement(By.xpath("//input[@name='oro_contact_address_form[street]']"));
					address.clear();
					address.sendKeys(new Faker().address().streetAddress());
					Thread.sleep(1000);

					WebElement city = driver.findElement(By.xpath("//input[@name='oro_contact_address_form[city]']"));
					city.clear();
					city.sendKeys(new Faker().address().city());
					Thread.sleep(1000);

//						Select dropDown2 = new Select(driver.findElement(By.id("(select2-drop-mask)[2]")));
//						Thread.sleep(1000);
//						dropDown2.selectByVisibleText(new Faker().address().state());
//						Thread.sleep(1000);
					// driver.findElement(By.id("(select2-drop-mask)[2]")).sendKeys(new
					// Faker().address().state());
					WebElement zipcode = driver
							.findElement(By.xpath("//input[@name='oro_contact_address_form[postalCode]']"));
					zipcode.clear();
					zipcode.sendKeys(new Faker().address().zipCode());
					Thread.sleep(1000);

					driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
					Thread.sleep(3000);
					System.out.println("The " + row + " data entered sucessfully");
				} else {
					System.out.println("Unable enter data to " + row);
				}

			} catch (Exception e) {

				System.out.println("The Edit button is not displayed!");
				System.out.println("The " + row + " customer address information does not exist!");

				Thread.sleep(2000);
				WebElement addbook = driver.findElement(By.xpath("//span[@class='action-wrapper']/button"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", addbook);

				Thread.sleep(1000);
				WebElement firstName = driver
						.findElement(By.xpath("//input[@name='oro_contact_address_form[firstName]']"));
				firstName.clear();
				firstName.sendKeys(new Faker().name().firstName());

				WebElement lastName = driver
						.findElement(By.xpath("//input[@name='oro_contact_address_form[lastName]']"));
				lastName.clear();
				lastName.sendKeys(new Faker().name().lastName());

				WebElement comapany = driver
						.findElement(By.xpath("//input[@name='oro_contact_address_form[organization]']"));
				comapany.clear();
				comapany.sendKeys(new Faker().company().name());

				Select dropDown1 = new Select(
						driver.findElement(By.xpath("//select[@name='oro_contact_address_form[country]']")));
				Thread.sleep(1000);
				dropDown1.selectByVisibleText(new Faker().country().name());

				WebElement address = driver.findElement(By.xpath("//input[@name='oro_contact_address_form[street]']"));
				address.clear();
				address.sendKeys(new Faker().address().streetAddress());
				Thread.sleep(1000);

				WebElement city = driver.findElement(By.xpath("//input[@name='oro_contact_address_form[city]']"));
				city.clear();
				city.sendKeys(new Faker().address().city());
				Thread.sleep(1000);

//					Select dropDown2 = new Select(driver.findElement(By.id("(select2-drop-mask)[2]")));
//					Thread.sleep(1000);
//					dropDown2.selectByVisibleText(new Faker().address().state());
//					Thread.sleep(1000);
				// driver.findElement(By.id("(select2-drop-mask)[2]")).sendKeys(new
				// Faker().address().state());
				WebElement zipcode = driver
						.findElement(By.xpath("//input[@name='oro_contact_address_form[postalCode]']"));
				zipcode.clear();
				zipcode.sendKeys(new Faker().address().zipCode());

				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

				Thread.sleep(3000);
				System.out.println("The " + row + " data entered sucessfully");

			}

			driver.navigate().back();

		}
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {

		Thread.sleep(2000);
		driver.close();
	}

}