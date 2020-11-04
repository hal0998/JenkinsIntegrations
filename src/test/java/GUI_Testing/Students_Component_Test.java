package GUI_Testing;

import org.testng.annotations.*;

import PageElements.Home_Page_Elements;
import PageElements.Students_Component;
import PageElements.loginPage_elements;
import TestBase.Pre_Condition;

public class Students_Component_Test {

	Students_Component stucomponent;

	@BeforeMethod
	public void Set_Up() {

		Pre_Condition.browser();
		new loginPage_elements().send_UserName(Pre_Condition.read_Pro("username"), Pre_Condition.read_Pro("password"));
		stucomponent = new Home_Page_Elements().expand_Students_Component();

	}

	@Test
	public void Students_Componen_Testing() {

		stucomponent.Click_All_Students();
		stucomponent.list_Students_Dtls();

	}

	@AfterMethod
	public void Tear_Down() {

		Pre_Condition.Kill_Browser();

	}
}
