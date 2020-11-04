package GUI_Testing;

import java.sql.Driver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageElements.Home_Page_Elements;
import PageElements.loginPage_elements;
import TestBase.Pre_Condition;

public class Home_Page {

	Home_Page_Elements homepage;

	@BeforeMethod
	public void Set_up() {

		Pre_Condition.browser();
		loginPage_elements loginPage = new loginPage_elements();
		loginPage.send_UserName(Pre_Condition.read_Pro("username"), Pre_Condition.read_Pro("password"));
		homepage = new Home_Page_Elements();

	}

	@Test
	public void Home_Page_Test() {
   
		homepage.student_info();
		homepage.teacher_info();
		homepage.parent_info();
		homepage.earning_Info();
       
	}

	@AfterMethod
	public void Tear_Down() {
		
		Pre_Condition.Kill_Browser();

	}

}
