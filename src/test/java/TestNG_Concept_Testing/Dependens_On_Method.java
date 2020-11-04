package TestNG_Concept_Testing;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.Pre_Condition;

public class Dependens_On_Method extends Pre_Condition {

	@Test
	public void Login_Page_Test() throws Exception {

		Pre_Condition.browser();
		Thread.sleep(40000);
		System.out.println(driver.getTitle());
		AssertJUnit.assertTrue(driver.getTitle().contains("Preschool - Admin Account"));

	}

	@Test(dependsOnMethods = "Login_Page_Test")
	public void Home_Page_Test() {

		boolean userInput = driver.findElement(By.xpath("//form[@action='index.html']/div[1]/input")).isDisplayed();
		boolean passInput = driver.findElement(By.xpath("//form[@action='index.html']/div[2]/input")).isDisplayed();
		boolean loginButton=driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed();
		
		if(userInput&&passInput&&loginButton) {
			
			
			
		}

	}

}
