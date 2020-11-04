package GUI_Testing;

import org.testng.annotations.*;

import PageElements.Home_Page_Elements;
import PageElements.Teacher_Component;
import PageElements.loginPage_elements;
import TestBase.Pre_Condition;

public class Teacher_Component_Test {

	Teacher_Component teachcom;

	@BeforeMethod
	public void Set_Up() {

		Pre_Condition.browser();
		loginPage_elements loginpage = new loginPage_elements();
		loginpage.send_UserName(Pre_Condition.read_Pro("username"), Pre_Condition.read_Pro("password"));
		Home_Page_Elements homepage = new Home_Page_Elements();
		teachcom = homepage.expand_Teachers_Component();
	}

	@Test
	public void Teacher_Component_Testing() {

		teachcom.click_All_Teacher();
		teachcom.list_All_Teacher_Dtls();

	}

	@AfterMethod
	public void Tear_Down() {

		Pre_Condition.Kill_Browser();

	}

}
