package eBankingAutomation.testCases;


import org.testng.annotations.Test;

import eBankingAutomation.pageObject.AddNewCustemor;
import eBankingAutomation.pageObject.LoginPage;
import net.bytebuddy.utility.RandomString;

public class TC_AddNewCustTest_003 extends BaseClass {

	@Test
	public void addNewCustemorData() throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userID);
		lp.setPassword(userPass);
		lp.clickSubmit();

		AddNewCustemor addcust = new AddNewCustemor(driver);
		addcust.clickNewCustomer();
		addcust.enterCustName("Archi");
		addcust.selectGenderf();
		addcust.enterDOB("07", "05", "1996");
		addcust.enterAddress("Rosevally");
		addcust.enterCity("Pune");
		addcust.enterState("MH");
		addcust.enterPIN("411027");
		addcust.enterMobile("3214854");
		addcust.enterEmail(randomMail() + "@gmail.com");
		addcust.enterPassword("random123");
		addcust.clickSubmit();
		
		System.out.println(driver.getTitle());
		
	
	}

	public String randomMail() {
		String randommail = RandomString.make(5);
		return randommail;
	}
}
