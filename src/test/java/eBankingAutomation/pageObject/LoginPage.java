package eBankingAutomation.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(css = "*[name=\"uid\"]")
	WebElement username;

	@FindBy(css = "*[name=\"password\"]")
	WebElement password;

	@FindBy(name = "btnLogin")
	WebElement loginsubmit;
	
	@FindBy(xpath= "//a[normalize-space()='Log out']")
	WebElement logout;
	
	
	
	public void setUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickSubmit() {
		loginsubmit.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
}