package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Pre_Condition;

public class Teacher_Component {

	public Teacher_Component() {

		PageFactory.initElements(Pre_Condition.driver, this);

	}

	@FindBy(xpath = "(//ul[@class='list-unstyled']/li/a)[1]")
	@CacheLookup
	WebElement AllTeacher;

	public void click_All_Teacher() {
		
		AllTeacher.click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

	}

	public void list_All_Teacher_Dtls() {

		int count = Pre_Condition.driver.findElements(By.xpath("(//div[@class='profile-widget'])")).size();
		for(int size=1;size <= count;size++ ) {
		String teacherName=Pre_Condition.driver.findElement(By.xpath("(//div[@class='profile-widget']/h4/a)["+size+"]")).getText();
	    String title=Pre_Condition.driver.findElement(By.xpath("(//div[@class='small text-muted'])["+size+"]")).getText();
	    System.out.println("\nThe Total Teacher Count is : "+count+"\n"+size+" : The Teacher Name is\t"+teacherName+"\tJob Title is\t"+title);
	    
		}
		

	}

}
