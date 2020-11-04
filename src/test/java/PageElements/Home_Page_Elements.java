package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Pre_Condition;

public class Home_Page_Elements {

	public Home_Page_Elements() {

		PageFactory.initElements(Pre_Condition.driver, this);

	}

	@FindBy(xpath = "//div[@class='content container-fluid']/div[1]/div[1]/div/div/h3")
	@CacheLookup
	WebElement studentCount;

	@FindBy(xpath = "//div[@class='content container-fluid']/div[1]/div[1]/div/div/span")
	@CacheLookup
	WebElement student;

	@FindBy(xpath = "//div[@class='content container-fluid']/div[1]/div[2]/div/div/span")
	@CacheLookup
	WebElement teacher;

	@FindBy(xpath = "//div[@class='content container-fluid']/div[1]/div[2]/div/div/h3")
	@CacheLookup
	WebElement teacherCount;

	@FindBy(xpath = "(//div[@class='dash-widget-info']/h3)[3]")
	@CacheLookup
	WebElement parentsCount;

	@FindBy(xpath = "(//div[@class='dash-widget-info']/span)[3]")
	@CacheLookup
	WebElement parent;

	@FindBy(xpath = "(//div[@class='dash-widget-info']/span)[4]")
	@CacheLookup
	WebElement totalElements;

	@FindBy(xpath = "(//div[@class='dash-widget-info']/h3)[4]")
	@CacheLookup
	WebElement totalEarning;

	@FindBy(xpath = "//div[@class='sidebar-menu']/ul/li[3]")
	@CacheLookup
	WebElement teacherComponent;

	@FindBy(xpath = "(//li[@class='submenu']/a/span)[3]")
	@CacheLookup
	WebElement studentComponent;

	public void student_info() {

		String stucount = studentCount.getText().toString();
		String stuname = student.getText().toString();
		System.out.println("The " + stuname + " Toatal Count is : " + stucount);

	}

	public void teacher_info() {

		String teaname = teacher.getText().toString();
		String teacount = teacherCount.getText();
		System.out.println("The " + teaname + " Total Count is : " + teacount);

	}

	public void parent_info() {

		String parentcount = parentsCount.getText().toString();
		String parentname = parent.getText().toString();
		System.out.println("The " + parentname + " total Count is : " + parentcount);

	}

	public void earning_Info() {

		String totalearningCount = totalEarning.getText().toString();
		String earning = totalElements.getText().toString();
		System.out.println("The " + earning + " is : " + totalearningCount);

	}

	public String get_HomePage_Title() {

		return Pre_Condition.driver.getTitle();

	}

	public Teacher_Component expand_Teachers_Component() {

		teacherComponent.click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		return new Teacher_Component();

	}

	public Students_Component expand_Students_Component() {

		studentComponent.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return new Students_Component();
	}

}
