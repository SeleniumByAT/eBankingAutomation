package eBankingAutomation.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import eBankingAutomation.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void setLoginData() {

		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userID);
		lp.setPassword(userPass);
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			
		} else {
			captureScreenshot(driver, "setLoginData");
			Assert.assertTrue(false);
		
			}
		lp.clickLogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

}
