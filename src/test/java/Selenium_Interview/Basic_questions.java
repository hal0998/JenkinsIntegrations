package Selenium_Interview;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Basic_questions {

	
	
	
	@Test
	public void Se_Test() {
		
		

		System.setProperty("webdriver.chrome.driver", "path of the selenium chrome driver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		WebElement elemetn = driver.findElement(By.id("text_box"));
		elemetn.sendKeys("hr");
		
		List<WebElement> tables = driver.findElements(By.id("table"));
		
		for(WebElement row : tables) {
			
			String rowName = row.getText();
		}
		
		driver.switchTo().frame(driver.findElement(By.xpath("dfjdfd")));
		
		driver.switchTo().frame(driver.findElement(By.xpath("dfdf")));
		
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
		
		Set<String> windows = driver.getWindowHandles();
		
		
		Select sel = new Select(driver.findElement(By.id("dfd")));
		
		sel.selectByVisibleText("dfd");
		sel.selectByValue("dfd");
		
		driver.findElement(By.xpath("dfdf")).isSelected();
		driver.findElement(By.id("dfdfd")).isEnabled();
		driver.findElement(By.xpath("dfdfd")).isDisplayed();
		
		// id, xpath, css, name, classname, tagname, linktext, partiallinktext
		
		Actions act = new Actions(driver);
		
		act.doubleClick(elemetn).build().perform();
		act.dragAndDrop(elemetn, elemetn).release().build().perform();
		            // source,  target
		act.moveToElement(elemetn).moveToElement(elemetn).click().build().perform();
		
		
		
		
	
		
		
		
		
		
		

				
		
		
	}
}
