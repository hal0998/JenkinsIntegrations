package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Pre_Condition;

public class Students_Component {

	public Students_Component() {

		PageFactory.initElements(Pre_Condition.driver, this);

	}

	@FindBy(xpath = "(//ul[@class='list-unstyled']/li/a)[3]")
	@CacheLookup
	WebElement all_student;

	public void Click_All_Students() {

		try {

			Thread.sleep(2000);
		} catch (Exception e) {

		}
		all_student.click();

		try {

			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}

	public void list_Students_Dtls() {

		int size = Pre_Condition.driver.findElements(By.xpath("//div[@class='profile-widget']")).size();

		for(int row=1;row<=size;row++) {
			
			String studentName=Pre_Condition.driver.findElement(By.xpath("(//div[@class='profile-widget']/h4/a)["+row+"]")).getText();
			String title=Pre_Condition.driver.findElement(By.xpath("(//div[@class='small text-muted'])["+row+"]")).getText();
		    System.out.println("\nThe Total Student Count is :\t"+size+"\nThe Student Name is :\t"+studentName+", Student Title is :\t"+title);
		
		}
		
	}

}
