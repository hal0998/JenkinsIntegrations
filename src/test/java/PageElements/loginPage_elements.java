package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Pre_Condition;

public class loginPage_elements {

	public loginPage_elements() {

		PageFactory.initElements(Pre_Condition.driver, this);

	}

	@FindBy(xpath = "//form[@action='index.html']/div[1]/input")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//form[@action='index.html']/div[2]/input")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	@CacheLookup
	WebElement loginButton;

	public Home_Page_Elements send_UserName(String name, String pass) {

		userName.sendKeys(name);
		password.sendKeys(pass);
		loginButton.click();
		return new Home_Page_Elements();

	}

}
