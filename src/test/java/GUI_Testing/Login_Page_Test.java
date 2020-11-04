package GUI_Testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageElements.Home_Page_Elements;
import PageElements.loginPage_elements;
import TestBase.Pre_Condition;
import Utilities.Tool_Box;

public class Login_Page_Test {

	Home_Page_Elements homePage;

	@BeforeMethod
	public void Set_up() {

		Pre_Condition.browser();
	}

	@Test
	public void LogInPage_Test() {

		loginPage_elements loginpage = new loginPage_elements();
		homePage = loginpage.send_UserName(Pre_Condition.read_Pro("username"), Pre_Condition.read_Pro("password"));
		String title = homePage.get_HomePage_Title();
		System.out.println("The Home Page Title is :\t" + title);
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(title.equalsIgnoreCase("Preschool - Admin Account"));
		sf.assertAll();

	}

	@AfterMethod
	public void Tear_Down() {

		Pre_Condition.Kill_Browser();

	}

}
