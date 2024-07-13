package eBankingAutomation.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustemor {
	WebDriver driver;

	public AddNewCustemor(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement addNewCusbtn;

	@FindBy(css = "input[name=\"name\"]")
	WebElement custName;

	@FindBy(css = "*[value=\"m\"]")
	WebElement malebtn;
	
	@FindBy(css = "*[value=\"f\"]")
	WebElement femalebtn;

	@FindBy(id = "dob")
	WebElement dateofBirth;

	@FindBy(css = "*[name=\"addr\"]")
	WebElement address;

	@FindBy(css = "input[name=\"city\"]")
	WebElement city;

	@FindBy(css = "input[name=\"state\"]")
	WebElement state;

	@FindBy(css = "input[name=\"pinno\"]")
	WebElement pin;

	@FindBy(css = "input[name=\"telephoneno\"]")
	WebElement mobile;

	@FindBy(name = "emailid")
	WebElement email;

	@FindBy(css = "input[name=\"password\"]")
	WebElement password;

	@FindBy(css = "input[name=\"sub\"]")
	WebElement submit;

	public void clickNewCustomer() {
		addNewCusbtn.click();
	}

	public void enterCustName(String cname) {
		custName.sendKeys(cname);
	}

	public void selectGenderm() {
		malebtn.click();
	}
	
	public void selectGenderf() {
		femalebtn.click();
	}

	public void enterDOB(String date, String month, String year) {
		dateofBirth.sendKeys(date);
		dateofBirth.sendKeys(month);
		dateofBirth.sendKeys(year);
	}

	public void enterAddress(String add) {
		address.sendKeys(add);
	}

	public void enterCity(String cityname) {
		city.sendKeys(cityname);
	}

	public void enterState(String statename) {
		state.sendKeys(statename);
	}

	public void enterPIN(String pinnum) {
		pin.sendKeys(pinnum);
	}

	public void enterMobile(String phone) {
		mobile.sendKeys(phone);
	}

	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickSubmit() {
		submit.click();
	}

}
